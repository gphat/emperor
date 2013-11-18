package emp

/**
 * A trait for code that is interested in being an Emperor plugin.
 */
trait Plugin {

  /**
   * Returns a list of events that this plugin would like to be notified about.
   */
  def relevantEvents: List[String]
}