package org.filemon.example

import org.scalajs.dom
import org.scalajs.dom.document

import scala.scalajs.js.annotation.JSExportTopLevel

object Main {


  def main(args: Array[String]): Unit = {
    appendString
    appendElement
    addButtonOnDomLoaded
  }

  //Dodanie stringa do b ody
  def appendString = document.body.append("Hello TouK")

  //Dodanie elementu do body
  def appendElement = {
    val parNode = document.createElement("p")
    parNode.textContent = "Hello World"
    document.body.appendChild(parNode)
  }

  //Dodanie listenera, ktory doda przycisk z listenerem gdt DOM sie zaladuje.
  def addButtonOnDomLoaded = document.addEventListener("DOMContentLoaded", { (e: dom.Event) => setupUI() })

  //Dodanie buttona + dodanie listenera
  def setupUI(): Unit = {
    val button = document.createElement("button")
    button.textContent = "Click me!"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      addClickedMessage()
    })
    document.body.appendChild(button)
  }

  //We can use it also in console (make is visible outside to js code as well)
  @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit = {
    document.body.appendChild(document.createElement("br"))
    document.body.append("You clicked the button!")
  }

}