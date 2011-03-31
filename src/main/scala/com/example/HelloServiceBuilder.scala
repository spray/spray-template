package com.example

import cc.spray._

trait HelloServiceBuilder extends ServiceBuilder {
  
  val helloService = {
    path("") {
      get { _.complete("Say hello to Spray!") }
    }
  }
  
}