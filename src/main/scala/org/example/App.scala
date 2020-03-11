package org.example

import org.apache.spark.sql.SparkSession

/**
 * @author ${user.name}
 */
object App {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    val spark = SparkSession
      .builder
      .master("local[*]")
      .appName("spark-titanic")
      .getOrCreate()

    val dF = spark.read
      .option("header", true)
      .csv("/home/adnls/data/Titanic.csv")

    dF.printSchema()
    dF.show()
  }

}
