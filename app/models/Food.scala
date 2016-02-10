package models

import play.api.libs.json.Reads
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Food(id: Long, name: String, information: String)
case class CreateFood(name: String, information: String)

object CreateFood {
  implicit val readsFoodToJson = (
    (__ \ "name").read(Reads.minLength[String](1)) and
      (__ \ "information").read(Reads.minLength[String](1))
    )(CreateFood.apply _)
}
