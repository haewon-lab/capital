package capital.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import capital.data.model.CapitalResponse

@Entity(tableName = "countries")
data class CountryEntity (
    @PrimaryKey
    val countryCode: String,

    val continent: String,
    val countryKo: String,
    val countryEn: String,

    val capitals: List<CapitalResponse>,
    val languages: List<String>
)