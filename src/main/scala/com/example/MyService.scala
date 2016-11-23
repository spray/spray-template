package com.example

import akka.actor.{ActorContext, Actor}
import spray.routing._
import spray.http._
import MediaTypes._
import scala.util.Success
import scala.concurrent.{ ExecutionContext, Future, Promise }
import ExecutionContext.Implicits.global
import spray.util.LoggingContext

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MyServiceActor extends Actor with MyService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute)
}


// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {

  val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      }
    } ~
    path("test-detach" / LongNumber) { id =>
      get {
        println(s"detach-out ${Thread.currentThread().getName}")
        detach(global) {
          println(s"detach-in-1 ${Thread.currentThread().getName}")
          Thread.sleep(5000)
          println(s"detach-in-2 ${Thread.currentThread().getName}")
          complete("OK")
        }
      }
    } ~
    path("test-future" / LongNumber) { id =>
      get { ctx =>
        println(s"future-out ${Thread.currentThread().getName}")
        Future({
          println(s"future-in-1 ${Thread.currentThread().getName}")
          Thread.sleep(5000)
          println(s"future-in-2 ${Thread.currentThread().getName}")
          ctx.complete("OK")
        })(global)
        println(s"future-out-2 ${Thread.currentThread().getName}")
      }
    }
}