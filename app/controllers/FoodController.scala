package controllers

import models.{CreateFood, Food}
import play.api.Logger
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc._


class FoodController extends Controller {

  Logger.info("Food Controller instantiated")

  implicit val writesFoodToJson = Json.writes[Food]
  implicit val readsFoodToJson = Json.reads[CreateFood]

  val foodService = service.FoodServiceImpl

  val listAllFoods = Action {
    Ok(Json.toJson(foodService.listAllFoods()))
  }

  val createNewFood = Action(parse.json) { implicit request =>
    request.body.validate[CreateFood] match {
      case JsSuccess(createFood, _) =>
        foodService.createNewFood(createFood.name, createFood.information) match {
          case Some(food) => Ok(Json.toJson(food))
          case None => InternalServerError
        }
      case JsError(errors) =>
        BadRequest
    }

  }

  def getFood(id: Long) = Action {
    foodService.getFood(id) match {
      case Some(food) => Ok(Json.toJson(food))
      case None => NotFound
    }
  }

  def updateFood(id: Long) = Action(parse.json) { implicit request =>
    request.body.validate[CreateFood] match {
      case JsSuccess(updateFood, _) =>
        foodService.updateFood(id, updateFood.name, updateFood.information) match {
          case Some(item) => Ok(Json.toJson(item))
          case None => InternalServerError
        }
      case JsError(errors) =>
        BadRequest
    }
  }

  def deleteFood(id: Long) = Action {
    if (foodService.deleteFood(id)) Ok else BadRequest
  }

}
