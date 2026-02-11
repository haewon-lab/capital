package capital.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CapitalResponse(
    @SerialName("ko") val ko: String,
    @SerialName("en") val en: String
)
