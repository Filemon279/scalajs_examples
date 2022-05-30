package org.filemon.example

import japgolly.scalajs.react.{BackendScope, Callback, ReactEventFromInput, ScalaComponent}
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^._

object SearchComponent {

  case class State(searchField: String)

  case class Props(){
    def make = component(this)
  }

  class Backend($: BackendScope[Props, State]) {

    def onSearchUpdate(e: ReactEventFromInput): Callback =
      $.modState((s: State) => s.copy(searchField = e.target.value))

    def render(p: Props, s: State): VdomElement =
      <.div(
        //<.input(^.`type`:="text", ^.onChange ==> onSearchUpdate), <- przez atrybut
        <.input.text(^.onChange ==> onSearchUpdate),
        <.div(s"You are looking for: ${s.searchField}")
      )
  }

  val component = ScalaComponent.builder[Props]
    .initialState(State(""))
    .renderBackend[Backend]
    .build

}
