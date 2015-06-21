package com.github.gluthra.fitnessz.app

class MyScalatraServlet extends FitnesszStack {

  get("/") {
    contentType="text/html"
    ssp("desktop.ssp", "welcomeText" -> "Hello to FitnessZ")

  }

  get("/:user/events") {

    val user = params("user")
    val eventContent = new EventService().getEventsForUser(user)

    contentType="text/html"
    ssp("event-calendar.ssp", "username" -> user, "events" -> eventContent)
  }

}
