package controllers

import akka.actor.ActorSystem
import javax.inject._
import model.{ATMLocation, Address, GeoLocation}
import play.api.libs.json.Json
import play.api.libs.ws._
import play.api.mvc._

import scala.concurrent.ExecutionContext

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

      Ok(views.html.atmLocator(cityName, Json.parse(response.body.stripMargin.split("\n").filter(_.size>6).toList.head).as[List[ATMLocation]].filter(_.address.city.toLowerCase == cityName.toLowerCase )))

    }

  }

}
