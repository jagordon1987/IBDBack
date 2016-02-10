package service

import java.util.concurrent.atomic.AtomicLong

import com.google.inject.Singleton
import models.Food

import scala.collection.concurrent.TrieMap

@Singleton
class FoodServiceImpl extends FoodService {

  private val foods = TrieMap.empty[Long, Food]
  private val seq = new AtomicLong

  override def listAllFoods(): Seq[Food] = foods.values.to[Seq]

  override def deleteFood(id: Long): Boolean = foods.remove(id).isDefined

  override def getFood(id: Long): Option[Food] = foods.get(id)

  override def updateFood(id: Long, name: String, information: String): Option[Food] = {
    val food = Food(id, name, information)
    foods.replace(id, food)
    Some(food)
  }

  override def createNewFood(name: String, information: String): Option[Food] = {
    val id = seq.incrementAndGet()
    val food = Food(id, name, information)
    foods.put(id, food)
    Some(food)

  }
}
