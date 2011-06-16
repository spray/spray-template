package com.example

import cc.spray._

trait HelloService extends Directives {
  
  val helloService = {
    path("") {
      get { _.complete("Say hello to Spray!") }
    }
  }
  
}