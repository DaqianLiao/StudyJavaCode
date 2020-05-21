package com.ldq.study.scala

import scala.util.control.Breaks
import util.control.Breaks._

object BreakDemo {

  def breakable(): Unit = {
    val numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    val loop = new Breaks;
    loop.breakable {
      for (a <- numList) {
        println("Value of a: " + a);
        if (a == 4) {
          loop.break;
        }
      }
    }
    println("After the loop");
  }

  def breakDirect(): Unit = {
    for (i <- 0 to 10) {
      if (i == 5) {
        break
      }
      println("value of i:" + i)
    }
  }

  def main(args: Array[String]): Unit = {
    breakable()
    println("----------------------")
    breakDirect()
  }
}
