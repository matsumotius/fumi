package com.myatsumoto.fumi
import com.myatsumoto.wabi.Wabi

class Fumi(input:String) {
  private val bwt   = new Bwt(input)
  private val first = new Wabi(bwt.first)
  private val last  = new Wabi(bwt.last)

  private val EMPTY_LIST = List(-1)
  private val NOT_FOUND  = (false, EMPTY_LIST)

  def search(input:String):List[Int] = {
    val str  = input.last.toString

    if (false == last.keys.contains(str)) {
      return EMPTY_LIST
    }

    val keys = last.keys.keySet.toList.sortWith(_<_)
    val next = keys(math.min(keys.indexOf(str)+1, keys.size-1))
 
    val (found, list) = count(input.dropRight(1), c(str), c(next))
    if (found) 
      return list.map(i => bwt.position(i))
    else 
      return EMPTY_LIST
  }

  private def count(input:String, start:Int, end:Int):(Boolean, List[Int]) = {
    if (start < 0 || end < 0 || start > end) {
      return NOT_FOUND
    }
    if (input.size < 1) {
      return (true, (start until end).toList)
    }
    val str = input.last.toString
    count(
      input.dropRight(1),
      c(str) + occ(str, start - 1),
      c(str) + occ(str, end)
    )
  }

  private def c(key:String):Int = {
    first.select(0, key)
  }

  private def occ(key:String, index:Int):Int = {
    last.rank(index, key)
  }

}
