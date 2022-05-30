package org.filemon.example

import japgolly.scalajs.react.extra.StateSnapshot
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{BackendScope, Reusability, ScalaComponent}
import monocle.macros.Lenses
import org.filemon.example.utils.StateSnapshotSupport
import japgolly.scalajs.react.ReactMonocle._

object RootComponent {

  @Lenses case class State(searchField: String)

  case class Props(title: String) {
    def make = component(this)
  }


  class Backend(val $: BackendScope[Props, State]) extends StateSnapshotSupport[Props, State] {
    implicit def reusability: Reusability[Props] =
      Reusability.derive

    def render(p: Props, s: State): VdomElement =
      <.div(
        <.h1(p.title),

        SearchComponent.Props(stateSnapshot(State.searchField)(s)).make,

        // TODO można wgl dać value bez snapshota
        DisplaySearchComponent.Props(StateSnapshot(State.searchField.get(s))).make
      )
  }

  val component = ScalaComponent.builder[Props]
    .initialState(State(""))
    .renderBackend[Backend]
    .build

}
