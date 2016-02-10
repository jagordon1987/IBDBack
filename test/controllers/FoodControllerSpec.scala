//package controllers
//
//import play.api.test.{FakeRequest, PlaySpecification}
//import play.api.libs.json.Json
//import helpers.FoodApp
//
///**
//  * Created by John1 on 09/02/2016.
//  */
//class FoodControllerSpec extends PlaySpecification {
//
//  "Food controller" should {
//
//    val foodCreate = Json.obj("name" -> "apple", "information" -> "good")
//    val createdFood = Json.obj("id" -> 1, "name" -> "apple", "information" -> "good")
//
//    "add a food" in new FoodApp {
//      val response = call(FoodController.createNewFood, FakeRequest().withJsonBody(foodCreate))
//      status(response) must equalTo (OK)
//      contentAsJson(response) must equalTo (createdFood)
//    }
//  }
//}
