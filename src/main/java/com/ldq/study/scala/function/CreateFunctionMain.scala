package com.ldq.study.scala.function

import java.util.Date

import com.ldq.study.scala.dataType.DataType

object CreateFunctionMain {
  //  简单的函数，传入两个int值相加
  def add(x: Int, y: Int): Int = {
    return x + y
  }

  //  定义一个可变参数的方法
  def printFunc(arg: String*): Unit = {
    for (elem <- arg) {
      println(s" elem = ${elem}")
    }
  }

  /**
    * 传参数方式
    * 1/按照顺序，按照类型传入参数（java常用方式，不灵活，java解决方式是build模式）
    * 2/可以根据形参的名字，不固定顺序随意传参数（灵活，局限是，必须知道形参名字）
    *
    * @param str
    * @param i
    */
  def printWithNoSeq(str: String, i: Int): Unit = {
    println(s"string type value = ${str}, int type value = ${i}")
  }

  //  可以在形参上面定义形参的默认值
  def defaultFunc(a: Int = 5): Int = {
    return a
  }


  /**
    * 返回值的方式有两种
    * 1/ 通过return返回，形如 return a
    * 2/ 直接返回，形如 a
    *
    * @param a
    * @return
    */
  def returnFunc(a: Int = 0): Int = {
    return a
  }

  def directReturnFunc(a: Int = 0): Int = {
    a
  }

  /**
    * 递归函数demo
    *
    * @param n
    * @return
    */
  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorial(n - 1)
  }

  /**
    * 高阶函数
    * 函数也可以当作一种参数
    *
    * @param func
    * @param a
    *
    */
  def apply(func: Int => String, a: Int): Unit = {
    println("执行func函数的到结果：\n" + func(a))
  }

  def func(a: Int): String = {
    "age = " + a
  }


  def noNameFunc(): Unit = {
    /**
      * 匿名函数
      */
    val inc = (x: Int) => x + 1
    println("匿名函数：自增 = " + inc(0))

    /**
      * 多个参数的匿名函数
      */
    val mul = (x: Int, y: Int) => x * y
    println("匿名函数：相乘 = " + mul(3, 5))

    /**
      * 无参数的匿名函数
      */
    val userDir = () => {
      System.getProperty("user.dir")
    }
    println(s"userDir = ${userDir()}")
  }

  /**
    * 偏函数，当一个函数有多个参数的时候，可以只写部分参数，
    * 此时得到了部分参数的新匿名函数-> 偏函数
    * 继续传参数个偏函数，得到结果
    */
  def partialFunc(): Unit = {
    val log = (date: Date, message: String) => {
      println(date + "----" + message)
    }

    val date = new Date()
    //    常规使用
    println(log(date, "jack"))
    println(log(date, "lucy"))
    //    偏函数使用
    val logWithName = log(date, _: String)
    println(logWithName("jack"))
    println(logWithName("lucy"))
  }

  /**
    * 函数柯里化
    * 类似于java中的build模式，将一次性传N个参数，变成每次可以传一个参数，
    * 传入部分参数的结果就是个匿名函数，当所有参数传完了，得到结果
    */
  def curryFunc(a: Int)(b: Int): Int = {
    a + b
  }


  /**
    * 传名调用
    * 在函数内部进行表达值的计算
    * 每次使用时，解释器都会计算一次表达式的值
    *
    * @param t
    */
  def delay(t: => Long): Unit = {
    println("在 delay方法内部")
    println("参数t = " + t)
    t
  }

  def time() = {
    println("在 time 方法内部，获取纳秒时间")
    System.nanoTime()
  }

  def main(args: Array[String]): Unit = {
    DataType.testDataType()
    println(s"add(3,5) = ${add(3, 5)}")

    printFunc("1", "2", "abc")
    printWithNoSeq("name:ldq", 18)
    printWithNoSeq(i = 18, str = "name:ldq")

    println("no arg, get default value: " + defaultFunc())
    println("get cal value: " + defaultFunc(2))

    println("return value: " + returnFunc())
    println("direct return value: " + directReturnFunc())

    println("递归函数demo： 斐波纳切数列 = " + factorial(3))
    apply(func, 20)

    noNameFunc()

    partialFunc()

    val result = curryFunc(3)(4)
    println(s"result = ${result}")

    delay(time())

  }
}
