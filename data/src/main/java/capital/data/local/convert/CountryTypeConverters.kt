package capital.data.local.convert

import androidx.room.TypeConverter
import capital.data.model.CapitalResponse
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CountryTypeConverters {
    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun fromStringList(value: List<String>?): String {
        return json.encodeToString(value ?: emptyList())
    }

    @TypeConverter
    fun toStringList(value: String?): List<String> {
        return value?.let { json.decodeFromString(it) } ?: emptyList()
    }

    @TypeConverter
    fun fromCapitalList(value: List<CapitalResponse>?): String {
        return json.encodeToString(value ?: emptyList())
    }

    @TypeConverter
    fun toCapitalList(value: String?): List<CapitalResponse> {
        return value?.let { json.decodeFromString(it) } ?: emptyList()
    }
}