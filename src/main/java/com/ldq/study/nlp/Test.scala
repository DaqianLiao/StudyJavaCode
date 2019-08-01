package com.ldq.study.nlp

import com.hankcs.hanlp.HanLP
import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary

import scala.collection.JavaConversions._

object Test {

  def main(args: Array[String]): Unit = {

    val sentence = "41,【 日期 】为什么 19960104 【 版  号 】1 【 标题 】" +
      "合巢芜高速公路巢芜段竣工 【 作者 】于是 彭建中 【 正文 】     " +
      "安徽合（肥）巢（湖）芜（湖）高速公路巢芜段日前竣工通车并投入营运。" +
      "合巢芜 高速公路是国家规划的京福综合运输网的重要干线路段，" +
      "是交通部确定１９９５年建成 的全国１０条重点公路之一。该条高速公路正线长８８公里。（彭建中）"
    println(transform(sentence))

  }

  /**
   *
   * @param sentence
   * @return
   */
  def transform(sentence: String): List[String] = {
    val list = HanLP.segment(sentence)
    CoreStopWordDictionary.apply(list)
    val path = "data/stopwords/中文停用词表.txt";
    val stopWords = StropWords.getStopWords(path)
    list.map(x => x.word.replaceAll(" ", ""))
      .filter(x => !stopWords.contains(x)).toList
  }
}

