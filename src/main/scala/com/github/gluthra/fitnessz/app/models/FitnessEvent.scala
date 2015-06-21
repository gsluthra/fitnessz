package com.github.gluthra.fitnessz.app.models

import com.mongodb.DBObject
import com.mongodb.casbah.MongoConnection
import org.bson.types.ObjectId
import org.joda.time.DateTime

import com.novus.salat.dao.SalatDAO
import com.novus.salat._
import com.novus.salat.global._

import com.mongodb.casbah.commons.conversions.scala.{RegisterConversionHelpers, RegisterJodaTimeConversionHelpers}

//Model
case class FitnessEvent(_id: ObjectId = new ObjectId, eventDate: DateTime, eventName: String, userId: String)

//DAO wrapped with salat
class FitnessEventDAO extends
  SalatDAO[FitnessEvent, ObjectId](collection= MongoConnection()("fitnesszDB")("user_events"))

//Query object
case class FitnessEventQueryParams(_id: Option[ObjectId] = None,
                                eventDate: Option[DateTime] = None,
                                eventName: Option[String] = None,
                                userId: Option[String] = None)
//Implicit converter for Salat
object FitnessEventConversions {
  RegisterConversionHelpers()
  RegisterJodaTimeConversionHelpers()

  implicit def paramsToDBObject(params: FitnessEventQueryParams): DBObject =
    grater[FitnessEventQueryParams].asDBObject(params)

  implicit def fitnessEventToDBObject(c: FitnessEvent): DBObject =
    grater[FitnessEvent].asDBObject(c)
}