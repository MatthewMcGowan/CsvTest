import java.time.LocalDateTime

/**
  * Created by Matt on 13/12/2017.
  */
case class CrimeStat(cdatetime: LocalDateTime,
                     address: String,
                     district: Int,
                     beat: String,
                     grid: Int,
                     crimedescr: String,
                     ucr_ncic_code: Int,
                     latitude: BigDecimal,
                     longitude: BigDecimal)
