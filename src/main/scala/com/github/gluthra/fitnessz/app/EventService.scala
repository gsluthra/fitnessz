package com.github.gluthra.fitnessz.app

import com.github.gluthra.fitnessz.app.models.FitnessEvent

class EventService {

  def getEventsForUser(user: String): Seq[FitnessEvent] = {
    new MongoService().getEventsForUser(user)
  }
}
