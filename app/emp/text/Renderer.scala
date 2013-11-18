package emp.text

import org.pegdown.PegDownProcessor
import org.pegdown.Extensions

/**
 * Utility for hiding the actual rendering implementation. Currently supports
 * Markdown only.
 */
object Renderer {

  val renderer = new PegDownProcessor(Extensions.ALL)

  /**
   * Render a string &mdash; that is assumed to be Markdown &mdash; into
   * HTML.
   *
   * Uses [[https://github.com/chenkelmann/actuarius Actuarius]] for rendering
   * @param markdown The text to render.
   */
  def render(markdown: Option[String]): String = {
    try {
      markdown.map({ m => renderer.markdownToHtml(m) }).getOrElse("")
    } catch {
      case e: Exception => ""
    }
  }
}