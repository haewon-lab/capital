package capital.data.source

import android.content.Context
import capital.data.model.CountryResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

class AssetDataSource @Inject constructor (
    @ApplicationContext private val context: Context
){
    private val jsonParser = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    fun getCountryData(): List<CountryResponse> {
        return try {
            // 1. assets 폴더에서 파일 열기
            val jsonString = context.assets.open("world.json")
                .bufferedReader()
                .use { it.readText() }

            // 2. 문자열 -> 객체 리스트로 변환
            jsonParser.decodeFromString(jsonString)

        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}