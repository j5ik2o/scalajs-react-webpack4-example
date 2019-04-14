package scalajsreact.template
import org.scalajs.dom
import scalajsreact.template.css.AppCSS
import scalajsreact.template.routes.AppRouter

import scala.scalajs.js.annotation.JSExportTopLevel

object ReactApp {

  @JSExportTopLevel("main")
  def main(): Unit = {
    AppCSS.load
    AppRouter.router().renderIntoDOM(dom.document.getElementById("root"))
  }

}
