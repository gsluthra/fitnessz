package com.github.gluthra.fitnessz.app

import com.github.gluthra.fitnessz.app.models.FitnessEvent
import com.mongodb.casbah.{Imports, MongoClient}
import com.mongodb.casbah.commons.MongoDBObject
import org.joda.time.DateTime

class MongoService() {

  val DBNAME: String = "fitnesszDB"
  val EVENTS_COLLECTION_NAME: String = "user_events"

  def convertUserDocToFitnessEvent(userDoc: Imports.DBObject): FitnessEvent = {
    println(userDoc)
    FitnessEvent(userDoc.get("_id").toString, DateTime.now(), userDoc.get("eventName").toString)
  }

  def getEventsForUser(userName: String): Seq[FitnessEvent] = {
    val mongoClient =  MongoClient()
    val db = mongoClient(DBNAME)
    val collection = db(EVENTS_COLLECTION_NAME)

    val builder = MongoDBObject.newBuilder
    builder += "userName" -> userName
    val query = builder.result

    val userDocs = collection.find(query)
    (for (userDoc <- userDocs) yield convertUserDocToFitnessEvent(userDoc)).toSeq
  }
}
