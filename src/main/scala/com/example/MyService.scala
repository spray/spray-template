package com.example

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._
import spray.json.{JsonFormat, DefaultJsonProtocol}

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

case class Query(query:String)
case class Prediction(document:String, score:Double)
case class PredictionResult(predictions:List[Prediction])

object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val impQueryFormat = jsonFormat1(Query)
    implicit val predictionFormat = jsonFormat2(Prediction)
    implicit val predictionResultFormat = jsonFormat1(PredictionResult)
}

// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService with spray.httpx.SprayJsonSupport {
  val myRoute = {
    import MyJsonProtocol._
    path("predict") {
      get {
        parameters('q) { q => {
            complete {
              val result = PredictionResult(List(Prediction("a", 1.0), Prediction("b", 0.5)))
              result
            }
          }
        }
      }
    } ~
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
    }    
  }
}