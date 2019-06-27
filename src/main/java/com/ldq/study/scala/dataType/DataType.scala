package com.ldq.study.scala.dataType

object DataType {
  //  定义无返回方法 类似于 public void func(){}
  def testDataType(): Unit = {
    println("___________________________")

    //    字符串类型用双引号定义
    val string = "string type"
    println(string)
    //    字符类型用单引号定义
    val char = 'd'
    println(char)

    //    多行字符串用"""-————"""
    val mulString =
      """
         abc
         bcd
      """
    println(mulString)

    //    转义符同java
    val stype = "hello\tworld\nshen\tzhen\n"
    println(stype)
  }

  def main(args: Array[String]): Unit = {

    testDataType()


  }
}
