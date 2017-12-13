import org.scalatest.FunSpec

/**
  * Created by Matt on 13/12/2017.
  */
class CsvRowReaderSpec extends FunSpec {
  describe("A CsvRowReader") {
    describe("given a non-empty csv") {
      describe("with all fields valid") {
        it("correctly returns all parsed values") {
          val output = CsvRowReader.getCrimeStats("SacramentocrimeJanuary2006.csv")

          assert(output.map(_.isSuccess).forall(_ == true))
          //TODO: Assert against actual content of object
        }
      }
    }

    describe("given an empty csv") {
      describe("with a header") {
        it("should return an empty list") {
          val output = CsvRowReader.getCrimeStats("emptyCsvWithHeader.csv")

          assert(output.isEmpty)
        }
      }

      describe("without a header") {
        it("should return an empty list") {
          val output = CsvRowReader.getCrimeStats("emptyCsvWithoutHeader.csv")

          assert(output.isEmpty)
        }
      }
    }
  }
}
