package com.github.gluthra.fitnessz.app

import org.scalatra._
import scalate.ScalateSupport

class MyScalatraServlet extends FitnesszStack {

  get("/") {
    <html>
      <head>
        <title>FitnessZ</title>
      </head>
      <body>
        <h1>Hello, world. Sample scalatra application!</h1>
        Say <a href="hello-scalate">hello to FitnessZ sample application</a>.
      </body>
    </html>
  }

}
