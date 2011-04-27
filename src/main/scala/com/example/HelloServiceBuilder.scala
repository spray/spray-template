package com.example

import cc.spray._
import builders.Remaining

trait HelloServiceBuilder extends ServiceBuilder {
  
  val helloService = {
    path(Remaining) { path =>
      get { _.complete("Say hello to Spray! (path: " + path + ')') }
    }
  }
  
}