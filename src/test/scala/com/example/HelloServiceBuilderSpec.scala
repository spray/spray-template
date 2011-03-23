package com.example

import org.specs.Specification
import cc.spray._
import test._
import http._
import HttpMethods._
import HttpStatusCodes._

class HelloServiceBuilderSpec extends Specification with SprayTest with HelloServiceBuilder {
  
  "The HelloService" should {
    "return a greeting for GET requests to the root path" in {
      testService(HttpRequest(GET, "/")) {
        helloService
      }.response.content.as[String] mustEqual Right("<h1>Say hello to Spray</h1>")
    }
    "leave GET requests to other paths unhandled" in {
      testService(HttpRequest(GET, "/pipapo")) {
        helloService
      }.handled must beFalse
    }
    "return a MethodNotAllowed error for POST requests to the root path" in {
      testService(HttpRequest(POST, "/")) {
        helloService
      }.response mustEqual failure(MethodNotAllowed, "HTTP method not allowed, supported methods: GET")
    }
  }
  
}