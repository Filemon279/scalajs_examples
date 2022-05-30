package org.filemon.example.http

import org.filemon.example.Account
import sttp.client3.{FetchBackend, Response, ResponseException, UriContext, asString, basicRequest}
import sttp.client3.circe.asJson

import scala.concurrent.{ExecutionContext, Future}

object Requests {

  def lookForAccounts(name: String)(implicit ec: ExecutionContext): Future[List[Account]] = {
    implicit val sttpBackend = FetchBackend()
    for {
      response <- basicRequest
        .get(uri"http://localhost:8080/accounts?owner=$name")
        .header("Access-Control-Allow-Origin", "*")
        .response(asJson[List[Account]])
        .send(sttpBackend)
        .flatMap(failFutureJsonOnResponseError(_))
    } yield response
  }


  def getTime()(implicit ec: ExecutionContext): Future[String] = {
    implicit val sttpBackend = FetchBackend()
    for {
      response <- basicRequest
        .get(uri"http://localhost:8080/time")
        .header("Access-Control-Allow-Origin", "*")
        .response(asString)
        .send(sttpBackend)
        .flatMap(failFutureOnResponseError(_))
    } yield response
  }

  def failFutureOnResponseError[T, E, B](r: Response[Either[String, String]]): Future[String] = {
    r.body match {
      case Right(value) => Future.successful(value)
      case Left(value) => Future.successful("error")
    }
  }

  def failFutureJsonOnResponseError[T, E, B](r: Response[Either[ResponseException[E, B], T]]): Future[T] = {
    r.body match {
      case Right(value) => Future.successful(value)
      case Left(error) => {
        println("error")
        Future.failed(error)
      }
    }
  }

}
