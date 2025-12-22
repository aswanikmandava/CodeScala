package com.amandava.actor

import akka.actor.{Actor, ActorSystem, Props}
import scala.concurrent.duration._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object SchedulerDemo extends App {
  case object Count
  class Scheduler extends Actor {
    private var i = 0
    override def receive: Receive = {
      case Count =>
        i += 1
        println(s"Count: $i")
        Thread.sleep(1500)
        val now = LocalDateTime.now()
        val formatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        println(s"Count: $i > $formatted")
    }
  }
  val mySystem = ActorSystem("Scheduler")
  val a1 = mySystem.actorOf(Props[Scheduler], "MyActor")
  implicit val ec = mySystem.dispatcher
  // schedule to send a message after certain duration of time
  // send a message to actor (a1) after 1 sec
  mySystem.scheduler.scheduleOnce(1.seconds, a1, Count)
  // Runs on a fixed timelines
  mySystem.scheduler.scheduleAtFixedRate(100.millis, 1000.millis, a1, Count)
  // give a initial delay of sometime
  // Runs with a fixed delay between messages
  // This avoids backpressure buildup
  val sched = mySystem.scheduler.scheduleWithFixedDelay(100.millis, 1000.millis, a1, Count)
  Thread.sleep(10000)
  // cancel the scheduler before terminating the actor system
  sched.cancel()
  mySystem.terminate()
}
