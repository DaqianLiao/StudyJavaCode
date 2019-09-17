package com.ldq.study.scala.base

/**
 * https://www.cnblogs.com/zhaohadoopone/p/9534242.html
 */
object Collection {

  //创建不可变map，只能读取，不能添加元素
  def immutableMap(): Unit = {
    println("读取不可变map")
    val status = Map((1, "a"), (2, "b"))
    println(status)
    println(status.get(1).get)
    //    status.put(2,"dd")

    val status1 = Map(1 -> "a", 2 -> "b")
    println(status1)
  }

  def main(args: Array[String]): Unit = {
    val map: scala.collection.mutable.Map[String, String] = scala.collection.mutable.Map[String, String]()
    map.put("fa", "d")

    println(map)

    val status = collection.mutable.Map((1, "a"), (2, "b"))
    status.put(4, "d")
    status += ((3, "c"))

    /**
     * 遍历循环打印map
     */
    println("for：")
    for ((k, v) <- status) {
      println(s"key: $k, value: $v")
    }

    /**
     * foreach case 表达式
     */
    println("foreach-case：")
    status.foreach {
      case (k, v) => println(s"key: $k,value: $v")
    }

    /**
     * tuple 方式
     */
    println("tuple方式：")
    status.foreach(x => println(s"key: ${x._1},value: ${x._2}"))

    /**
     * keys,values
     */
    println("keys/values：")
    status.keys.foreach((key) => print(key + " "))
    println("")
    status.values.foreach((key) => print(key+" "))

    /**
     * mapValues 对每个value操作
     */
    println(status.mapValues(_.toUpperCase))

    /**
     * transform 将键值进行操作：
     * newValue = key+value
     */
    println(status.transform((k, v) => k + v))

    if (status.contains(1)) println("found 1a") else println("not found")
    immutableMap()
  }

}
