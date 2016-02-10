package service

import helpers.FoodApp
import models.{CreateFood, Food}
import org.specs2.mutable.Specification
import play.api.test._
import play.api.test.Helpers._
import service.FoodServiceImpl


class FoodServiceSpec extends Specification {
  "A food service" should {

    val foodService = new FoodServiceImpl

    "add a food" in new FoodApp {
      foodService.createNewFood("apple" ,"good") must beSome (Food(1, "apple", "good"))
    }

//    "list items" in new FoodApp {
//      var foodService1 = FoodServiceImpl
//      foodService1.listAllFoods() must beEmpty
//      foodService1.createNewFood("apple" ,"good")
//      foodService1.listAllFoods must haveSize (1)
//      foodService1.listAllFoods must contain (Food(1, "apple", "good"))
//    }

//    "get a food item" in new FoodApp {
//      val maybeFood = for {
//        createdFood <- foodService.createNewFood("apple" ,"good")
//        food <- foodService.getFood(createdFood.id)
//      } yield food
//      maybeFood must beSome (Food(1, "apple" ,"good"))
//    }
//
//    "update an item" in new FoodApp {
//      val maybeItem = for {
//        createdItem <- foodService.create("Play! Framework Essentials", 42)
//        updatedItem <- foodService.update(createdItem.id, createdItem.name, 10)
//        item <- foodService.get(updatedItem.id)
//        if item == updatedItem // Be sure that `Shop.update` returns the updated item
//      } yield item
//      maybeItem must beSome (Item(1, "Play! Framework Essentials", 10))
//    }
//
//    "delete an item" in new FoodApp {
//      val maybeDeleted = for {
//        createdItem <- foodService.create("Play! Framework Essentials", 42)
//        deleted = foodService.delete(createdItem.id)
//      } yield (deleted, shop.get(createdItem.id))
//      maybeDeleted must beSome ((true, None))
//    }


  }
}
