/**
  * Created by Matt on 13/12/2017.
  */

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import scala.io.Source.fromResource
import scala.util.Try

object CsvRowReader {
  def getCrimeStats(resourceName: String): Stream[Try[CrimeStat]] = {
    getRowsNoHeader(resourceName)
      .map(_.split(','))
      .map(parseCrimeStat(_))
  }

  private def getRowsNoHeader(resourceName: String) = {
    fromResource(resourceName).getLines().toStream.tail
  }

  private def parseCrimeStat(row: Seq[String]) = {
    Try(
      CrimeStat(
        LocalDateTime.parse(row(0), DateTimeFormatter.ofPattern("M/d/yy H:mm")),
        row(1),
        row(2).toInt,
        row(3),
        row(4).toInt,
        row(5),
        row(6).toInt,
        BigDecimal(row(7)),
        BigDecimal(row(8))))
  }
}
