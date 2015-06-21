package com.github.gluthra.fitnessz.app

import org.scalatra._
import scalate.ScalateSupport

class MyScalatraServlet extends FitnesszStack {

  get("/") {
    contentType="text/html"
    ssp("desktop.ssp", "welcomeText" -> "Hello to FitnessZ")

  }

  get("/:user/events") {

    val user = params("user")
    val content = new EventService().getEventsForUser(user)

    contentType="text/html"
    ssp("hello-scalate.ssp", "username" -> user)
  }

}
