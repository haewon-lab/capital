package capital.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryResponse(
    @SerialName("country_code") val countryCode: String,
    @SerialName("continent") val continent: String,
    @SerialName("country_ko") val countryKo: String,
    @SerialName("country_en") val countryEn: String,
    @SerialName("capitals") val capitals: List<CapitalResponse>,
    @SerialName("languages") val languages: List<String>
)
