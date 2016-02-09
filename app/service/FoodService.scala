package service

import models.Food

trait FoodService {
  def listAllFoods(): Seq[Food]
  def createNewFood(name: String, information: String): Option[Food]
  def getFood(id: Long): Option[Food]
  def updateFood(id: Long, name: String, information: String): Option[Food]
  def deleteFood(id: Long): Boolean
}
