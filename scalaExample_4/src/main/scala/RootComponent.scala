package org.filemon.example

import japgolly.scalajs.react.{BackendScope, ScalaComponent}
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^._

object RootComponent {

  case class Props(title: String){
    def make = component(this)
  }

  class Backend($: BackendScope[Props, Unit]) {
    def render(p: Props): VdomElement =
      <.div(
        <.h1(p.title),
        SearchComponent.Props().make
      )
  }

  val component = ScalaComponent.builder[Props]
    .stateless
    .renderBackend[Backend]
    .build

}
