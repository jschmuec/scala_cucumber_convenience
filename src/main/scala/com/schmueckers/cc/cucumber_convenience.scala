package com.schmueckers.cc

import java.util

import io.cucumber.datatable.DataTable

import scala.collection.JavaConverters._
import scala.collection.mutable

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
    val asMaps: util.List[util.Map[String, String]] = dataTable.asMaps

    val asScalaMaps = List( asMaps.asScala : _* )

    def toUnmutableMap( mm : util.Map[String,String] ) = Map( mm.asScala.toList :_*  )

    asScalaMaps.map( toUnmutableMap )
  }

  /**
    * Class to extend the Cucumber DataTable with some Scala scentric functionality
    *
    * @param dt The DataTable we want to handle in Scala
    */
  implicit class CucumberDataTableExtensions(dt: DataTable) {
    def asScalaMaps: List[Map[String, String]] = dataTableToScalaMaps(dt)

    def asScalaList: List[String] = List(dt.asList(classOf[String]).asScala: _*)
  }

}
