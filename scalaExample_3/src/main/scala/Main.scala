package org.filemon.example

import org.scalajs.dom.document

object Main {

  def main(args: Array[String]): Unit = {
    RootComponent.Props("Hello" :: "World" :: Nil)
      .make
      .renderIntoDOM(document.getElementById("App"))
  }
}