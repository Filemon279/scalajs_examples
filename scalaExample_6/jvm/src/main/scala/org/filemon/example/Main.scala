package org.filemon.example

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import ch.megard.akka.http.cors.scaladsl.CorsDirectives.cors
import ch.megard.akka.http.cors.scaladsl.settings.CorsSettings
import io.circe.syntax._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._

import java.time.LocalDateTime
import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem(Behaviors.empty, "touk-server")
    implicit val executionContext: ExecutionContextExecutor = system.executionContext

    val route = cors() {
      path("accounts") {
        get {
          parameters("owner") { owner =>
            complete(StatusCodes.OK, MockData.accounts.filter(_.owner.equals(owner)).asJson)
          }
        }
      } ~
      path("time") {
        get {
          complete(StatusCodes.OK, LocalDateTime.now().toString)
        }
      }
    }


    /////
    val bindingFuture = Http().newServerAt("localhost", 8080).bind(route)
    println(s"Server now online...\nPress RETURN to stop...")
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }

}

