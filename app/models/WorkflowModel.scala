package models

import anorm._
import anorm.SqlParser._
import emp.util.AnormExtension._
import emp.util.Pagination.Page
import org.joda.time.DateTime
import play.api.db.DB
import play.api.Play.current
import play.Logger

case class Workflow(id: Pk[Long] = NotAssigned, name: String, description: Option[String], dateCreated: DateTime)

case class WorkflowStatus(id: Pk[Long], workflowId: Long, statusId: Long, name: String, position: Int)

object WorkflowModel {

  val allQuery = SQL("SELECT * FROM workflows")
  val allStatuses = SQL("SELECT * FROM workflow_statuses JOIN ticket_statuses ON (ticket_statuses.id = workflow_statuses.status_id) WHERE workflow_statuses.workflow_id={id} ORDER BY position ASC")
  val allAgileStatuses = SQL("SELECT * FROM workflow_statuses JOIN ticket_statuses ON (ticket_statuses.id = workflow_statuses.status_id) WHERE workflow_statuses.workflow_id={id} AND agile_visible=true ORDER BY position ASC")
  val getByIdQuery = SQL("SELECT * FROM workflows WHERE id={id}")
  val getWorkflowForTicketQuery = SQL("SELECT wf.* FROM tickets t JOIN projects p ON p.id = t.project_id JOIN workflows wf ON wf.id = p.workflow_id WHERE t.id={id}")
  val getWorkflowStatusByIdQuery = SQL("SELECT * FROM workflow_statuses JOIN ticket_statuses ON (ticket_statuses.id = workflow_statuses.status_id) WHERE workflow_statuses.id={id}")
  val listQuery = SQL("SELECT * FROM workflows LIMIT {count} OFFSET {offset}")
  val listCountQuery = SQL("SELECT count(*) FROM workflows")
  val addQuery = SQL("INSERT INTO workflows (name, description) VALUES ({name}, {description})")
  val updateQuery = SQL("UPDATE workflows SET name={name}, description={description} WHERE id={id}")
  val deleteQuery = SQL("DELETE FROM workflows WHERE id={id}")
  val getStartingStatus = SQL("SELECT * FROM workflow_statuses JOIN ticket_statuses ON ticket_statuses.id = workflow_statuses.status_id WHERE workflow_id={id} ORDER BY position ASC LIMIT 1")
  val getPrevStatus = SQL("SELECT * FROM workflow_statuses JOIN ticket_statuses ON (ticket_statuses.id = workflow_statuses.status_id) WHERE position < {position} AND workflow_id={workflow_id} ORDER BY position DESC LIMIT 1")
  val getNextStatus = SQL("SELECT * FROM workflow_statuses JOIN ticket_statuses ON (ticket_statuses.id = workflow_statuses.status_id) WHERE position > {position} AND workflow_id={workflow_id} ORDER BY position ASC LIMIT 1")
  val verifyStatusInWorkflow = SQL("SELECT count(*) FROM workflow_statuses WHERE status_id={status_id} AND workflow_id={workflow_id}")

  val workflow = {
    get[Pk[Long]]("id") ~
    get[String]("name") ~
    get[Option[String]]("description") ~
    get[DateTime]("date_created") map {
      case id~name~description~dateCreated => Workflow(id, name, description, dateCreated)
    }
  }

  val workflowStatus = {
    get[Pk[Long]]("workflow_statuses.id") ~
    get[Long]("workflow_statuses.workflow_id") ~
    get[Long]("ticket_statuses.id") ~
    get[String]("ticket_statuses.name") ~
    get[Int]("workflow_statuses.position") map {
      case id~workflowId~statusId~name~position => WorkflowStatus(id, workflowId, statusId, name, position)
    }
  }

  /**
   * Create a workflow.
   */
  def create(workflow: Workflow): Workflow = {

    DB.withConnection { implicit conn =>
      val id = addQuery.on(
        'name         -> workflow.name,
        'description  -> workflow.description
      ).executeInsert()

      getById(id.get).get
    }
  }

  /**
   * Delete a workflow.
   */
  def delete(id: Long) {
    DB.withConnection {implicit conn =>
      deleteQuery.on(
        'id -> id
      ).execute
    }
  }

  /**
   * Get a workflow by id.
   */
  def getById(id: Long) : Option[Workflow] = {

    DB.withConnection { implicit conn =>
      getByIdQuery.on('id -> id).as(workflow.singleOpt)
    }
  }

  def getForTicket(ticketId: Long): Option[Workflow] = {

    DB.withConnection { implicit conn =>
      getWorkflowForTicketQuery.on('id -> ticketId).as(workflow.singleOpt)
    }
  }

  def getStatusById(id: Long): Option[WorkflowStatus] = {

    DB.withConnection { implicit conn =>
      getWorkflowStatusByIdQuery.on('id -> id).as(workflowStatus.singleOpt)
    }
  }

  /**
   * Get statuses in this workflow.
   */
  def getStatuses(id: Long, agile: Boolean = false) : Seq[WorkflowStatus] = {

    DB.withConnection { implicit conn =>
      if(agile) {
        allAgileStatuses.on('id -> id).as(workflowStatus.*)
      } else {
        allStatuses.on('id -> id).as(workflowStatus.*)
      }
    }
  }

  /**
   * Get the "previous" status before the provided one.
   */
  def getPreviousStatus(workflowStatusId: Long) : Option[WorkflowStatus] = {

    val ws = this.getStatusById(workflowStatusId)

    ws match {
      case Some(status) => {
        DB.withConnection { implicit conn =>

          getPrevStatus.on(
            'position   -> status.position,
            'workflow_id-> status.workflowId
          ).as(workflowStatus.singleOpt)
        }
      }
      case None => None
    }
  }

  /**
   * Get the "next" status after the provided one.
   */
  def getNextStatus(workflowStatusId: Long) : Option[WorkflowStatus] = {

    val ws = this.getStatusById(workflowStatusId)

    ws match {
      case Some(status) => {
        DB.withConnection { implicit conn =>

          getNextStatus.on(
            'position   -> status.position,
            'workflow_id-> status.workflowId
          ).as(workflowStatus.singleOpt)
        }
      }
      case None => None
    }
  }

  /**
   * Get the status that a ticket should have when it is created in
   * his workflow.
   */
  def getStartingStatus(workflowId: Long) : Option[WorkflowStatus] = {

    DB.withConnection { implicit conn =>
      getStartingStatus.on('id -> workflowId).as(workflowStatus.singleOpt)
    }
  }

  def getAll: List[Workflow] = {

    DB.withConnection { implicit conn =>
      allQuery.as(workflow.*)
    }
  }

  def list(page: Int = 1, count: Int = 10) : Page[Workflow] = {

      val offset = count * (page - 1)

      DB.withConnection { implicit conn =>
        val workflows = listQuery.on(
          'count  -> count,
          'offset -> offset
        ).as(workflow.*)

        val totalRows = listCountQuery.as(scalar[Long].single)

        Page(workflows, page, count, totalRows)
      }
  }

  /**
   * Update a workflow
   */
  def update(id: Long, workflow: Workflow): Option[Workflow] = {

    DB.withConnection { implicit conn =>
      updateQuery.on(
        'id         -> id,
        'name       -> workflow.name,
        'description-> workflow.description
      ).execute
      getById(id)
    }
  }

  /** Verify that given status is a member of the given workflow.
   *
   * Selects a count where status_id and workflow_id equal the given
   * arguments. Returns true if any are found, otherwise false.
   */
  def verifyStatusInWorkflow(workflowId: Long, statusId: Long) : Boolean = {
    DB.withTransaction { implicit conn =>
      val count = verifyStatusInWorkflow.on(
        'workflow_id-> workflowId,
        'status_id  -> statusId
      ).as(scalar[Long].single)

      count match {
        case 0 => false
        case _ => true
      }
    }
  }
}
