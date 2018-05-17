package com.schmueckers.cc

import scala.collection.JavaConverters._
import scala.collection.mutable
import cucumber.api.DataTable

trait cucumber_convenience {
  val n = """((?:\d*\.)?\d+)""" // capture a number
  val nn =
    """(?:\d*\.)?\d+""" // non-capture a number

  /**
    * Capturing a word
    */
  val r_w =
    """(\w+)""" // capturing word

  /**
    * Non capturing a workd
    */
  val r_nw =
    """(?:\w+)""" // non capturing word

  /**
    * Capturing an int
    */
  val r_ing =
    """([+-]?\d)+"""

  /**
    * Regex string matching multiple words without spaces
    */
  val r_mw =
    """(\w+(?: \w+)*)"""
  /**
    * Regex matching multiple words followed by a space.
    *
    * use inside an expression
    */
  val r_mws =
    s"""$r_mw +"""

  /**
    * reg ex for multiple words with spaces
    */
  val r_smw =
    s""" $r_mw"""

  def dataTableToScalaMaps(dataTable: DataTable): List[Map[String, String]] = {
    val mutableListMap = dataTable.asMaps(classOf[String], classOf[String]).asScala.map(_.asScala)
    List(mutableListMap: _*).map((mm: mutable.Map[String, String]) => Map[String, String](mm.toSeq: _*))
  }
}
