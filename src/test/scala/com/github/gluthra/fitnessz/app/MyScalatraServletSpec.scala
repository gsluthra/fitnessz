package com.github.gluthra.fitnessz.app

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class MyScalatraServletSpec extends ScalatraSpec { def is = s2"""
  GET / on MyScalatraServlet
    should return status 200              $root200

  GET /unknown on MyScalatraServlet
    should return status 404              $rootUnknown

  GET /public on MyScalatraServlet
    should return status 200              $rootPublic

  """

  addServlet(classOf[MyScalatraServlet], "/*")

  def root200 = get("/") {
    status must_== 200
  }

  def rootUnknown = get("/unknown") {
    status must_== 404
  }

  def rootPublic = get("/public/") {
    status must_== 200
  }
}
