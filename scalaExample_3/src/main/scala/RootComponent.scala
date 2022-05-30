package org.filemon.example

import japgolly.scalajs.react.{BackendScope, ScalaComponent}
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^._

object RootComponent {

  case class Props(words: List[String]){
    def make = component(this)
  }

  class Backend($: BackendScope[Props, Unit]) {
    def render(p: Props): VdomElement =
      <.div(
        <.div(p.words.length, " items found:"),
        <.ol(p.words.toVdomArray(i => <.li(i)))
      )
  }

  val component = ScalaComponent.builder[Props]
    .stateless
    //.initialState(...)
    .renderBackend[Backend]
    .build

}
