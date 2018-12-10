package controllers

import akka.actor.ActorSystem
import javax.inject._
import model.{ATMLocation, Address, GeoLocation}
import play.api.libs.json.Json
import play.api.libs.ws._
import play.api.mvc._
import play.api.Logger
import scala.concurrent.ExecutionContext

/**
  * This controller creates an `Action` that demonstrates how to write
  * simple asynchronous code in a controller. It uses a timer to
  * asynchronously delay sending a response for 1 second.
  *
  * @param cc          standard controller components
  * @param actorSystem We need the `ActorSystem`'s `Scheduler` to
  *                    run code after a delay.
  * @param exec        We need an `ExecutionContext` to execute our
  *                    asynchronous code.  When rendering content, you should use Play's
  *                    default execution context, which is dependency injected.  If you are
  *                    using blocking operations, such as database or network access, then you should
  *                    use a different custom execution context that has a thread pool configured for
  *                    a blocking API.
  */
@Singleton
class Controller @Inject()(cc: ControllerComponents, actorSystem: ActorSystem, ws: WSClient)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  implicit val geoLocationFormat = Json.format[GeoLocation]
  implicit val addressFormat = Json.format[Address]
  implicit val atmLocationFormat = Json.format[ATMLocation]



  def index = Action {
    Ok("OK")
  }

  def atmLocation(cityName: String) = Action.async {


    ws.url("https://www.ing.nl/api/locator/atms/").get().map { response =>


      //    Json.toJson(Json.parse(response.body.stripMargin.split("\n").filter(_.size>6).toList.head).as[List[ATMLocation]].filter(_.address.city.toLowerCase == cityName.toLowerCase )).toString
      //val atmLocations =

      Ok(views.html.atmLocator(cityName, Json.parse(response.body.stripMargin.split("\n").filter(_.size>6).toList.head).as[List[ATMLocation]].filter(_.address.city.toLowerCase == cityName.toLowerCase )))


    }

  }


}
