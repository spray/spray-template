package com.example

import org.slf4j.LoggerFactory
import akka.config.Supervision._
import akka.actor.{Supervisor, Actor}
import cc.spray.{SprayCanRootService, HttpService}
import cc.spray.can.HttpServer

object Boot extends App {

  LoggerFactory.getLogger(getClass) // initialize SLF4J early

  val mainModule = new HelloService {
    // bake your module cake here
  }

  val httpService    = Actor.actorOf(new HttpService(mainModule.helloService))
  val rootService    = Actor.actorOf(new SprayCanRootService(httpService))
  val sprayCanServer = Actor.actorOf(new HttpServer())

  Supervisor(
    SupervisorConfig(
      OneForOneStrategy(List(classOf[Exception]), 3, 100),
      List(
        Supervise(httpService, Permanent),
        Supervise(rootService, Permanent),
        Supervise(sprayCanServer, Permanent)
      )
    )
  )
}