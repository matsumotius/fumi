package com.myatsumoto.fumi

case class BwtRow(position:Int, str:String) {}

class Bwt(input:String) {

  val data  = transform(input)
  val first = data.map(row => row.str.first).mkString
  val last  = data.map(row => row.str.last).mkString

  def transform(input:String):Array[BwtRow] = {
    (0 until input.size).map(i =>
      new BwtRow(i, input.drop(i) + input.take(i))
    ).sortWith(_.str < _.str).toArray
  }

  def position(index:Int):Int = {
    data(index).position
  }
}
