package org.filemon.example

import japgolly.scalajs.react.{BackendScope, Callback, ReactEventFromInput, ScalaComponent}
import japgolly.scalajs.react.extra.StateSnapshotF.StateSnapshot
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^.{<, ^}

object SearchComponent {

  case class Props(searchField: StateSnapshot[String]) {
    def make = component(this)
  }

  class Backend($: BackendScope[Props, Unit]) {

    def onSearchUpdate(p: Props)(e: ReactEventFromInput): Callback =
      p.searchField.setState(e.target.value)

    def render(p: Props): VdomElement =
      <.div(
        <.input.text(^.onChange ==> onSearchUpdate(p)),
      )
  }

  val component = ScalaComponent.builder[Props]
    .stateless
    .renderBackend[Backend]
    .build

}
