package com.amandava.akka.http
import scala.util.{Failure, Success}
import akka.actor.ActorSystem
import akka.http.scaladsl.model.headers.RawHeader
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers._
import akka.http.scaladsl.server.Directives._

import scala.concurrent.ExecutionContext.Implicits.global
// This runs a HTTP server
object HttpActorDemo extends App {
  // create an actor system
  implicit val mySystem: ActorSystem = ActorSystem("myHTTPSrv")
  val port = 9090
  // create the route
  val route: Route = path("home" / "index") {   // matches /home/index path from client
    // HTTP GET request
    // get directive allows to create a route that accepts GET request
    get {
      // check if the transactionId header is passed
      optionalHeaderValueByName("apiKey") { aKey =>
          respondWithHeader(RawHeader("Authentication", "Completed")) {
            println(s"Received GET request with header apiKey: $aKey")
            // successfully processed
            // send HTTP response using complete()
            // complete("OK")
            complete(
              HttpResponse(
                status = StatusCodes.OK,
                entity = HttpEntity(ContentTypes.`application/json`, """{"message": "processed"}""")
              )
            )
          }
      }
    }
  }

  // create a nested route using pathPrefix
//  val nestedRoute: Route = pathPrefix("orders") { // matches path starting with /orders
//    path("history") & pathEnd {  // this inner route matches /orders/history
//      complete("No orders found")
//    }
//  }

  // instantiate the server instance and bind to IP:Port and defined route
  val myHttpServer = Http().newServerAt("localhost", port).bind(route)
  myHttpServer.onComplete {
    case Success(obj) => println(s"Started server on port $port")
    case Failure(e) => println(s"Failed to start server: ${e.getMessage}")
  }
}
