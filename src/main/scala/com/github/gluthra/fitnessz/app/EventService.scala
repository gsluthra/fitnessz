package com.github.gluthra.fitnessz.app

import com.github.gluthra.fitnessz.app.models.{FitnessEventQueryParams, FitnessEventDAO, FitnessEvent}
import com.github.gluthra.fitnessz.app.models.FitnessEventConversions._
import org.joda.time.DateTime

class EventService {

  def getEventsForUser(userId: String): List[FitnessEvent] = {
    val fitnessEventDao = new FitnessEventDAO()
    fitnessEventDao.find(FitnessEventQueryParams(userId = Some(userId))).toList
  }

  def createEventForUser(userId: String) = {
    val fitnessEventDao = new FitnessEventDAO()
    val event = FitnessEvent(eventName = "HIIT", eventDate = new DateTime(), userId = userId)
    val id = fitnessEventDao.insert(event)
    assert(id.isDefined)
  }
}
