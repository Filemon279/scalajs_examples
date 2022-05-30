package org.filemon.example

import japgolly.scalajs.react.ReactMonocle._
import japgolly.scalajs.react.extra.StateSnapshot
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{AsyncCallback, BackendScope, Callback, Reusability, ScalaComponent}
import monocle.macros.Lenses
import org.filemon.example.http.Requests
import org.filemon.example.utils.StateSnapshotSupport

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.scalajs.js.timers.setInterval

object RootComponent {

  @Lenses case class State(searchField: String, response: String, serverTime: String)

  case class Props(title: String) {
    def make = component(this)
  }


  class Backend(val $: BackendScope[Props, State]) extends StateSnapshotSupport[Props, State] {
    def render(p: Props, s: State): VdomElement =
      <.div(
        <.h1(p.title),

        SearchComponent.Props(stateSnapshot(State.searchField)(s)).make,

        DisplaySearchComponent.Props(StateSnapshot(State.searchField.get(s))).make,

        SearchButton.Props(stateSnapshot(State.response)(s), stateSnapshot(State.searchField)(s)).make,

        <.div("API RESPONSE: ", s.response),

        <.div("Server time: ", s.serverTime, ^.marginTop:="5px", ^.border:="1px solid black", ^.width:="300px")
      )
  }

  val component = ScalaComponent.builder[Props]
    .initialState(State("", "", "loading..."))
    .renderBackend[Backend]
    .componentDidMount($ => Callback {
      setInterval(500.millis)(
        Requests.getTime().map(a => $.modState((s: State) => s.copy(serverTime = a)).runNow())
      )
    })
    .build

}
