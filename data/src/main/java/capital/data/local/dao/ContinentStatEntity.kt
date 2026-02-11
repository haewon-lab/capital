package capital.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import capital.data.local.entity.CountryEntity
import kotlinx.coroutines.flow.Flow

data class ContinentStatEntity(
    val continent: String,
    val count: Int
)

@Dao
interface CountryDao {
    // 대륙별 국가 수 조회
    @Query("SELECT continent, COUNT(*) as count FROM countries GROUP BY continent")
    fun getContinentStats(): Flow<List<ContinentStatEntity>>

    // 특정 대륙의 국가 목록 조회
    @Query("SELECT * FROM countries WHERE continent = :continent ORDER BY countryKo ASC")
    fun getCountriesByContinent(continent: String): Flow<List<CountryEntity>>

    // 국가 상세 조회
    @Query("SELECT * FROM countries WHERE countryCode = :code")
    fun getCountryDetail(code: String): Flow<CountryEntity>

    // 초기 데이터 삽입
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(countries: List<CountryEntity>)

    // 데이터 개수 확인
    @Query("SELECT COUNT(*) FROM countries")
    suspend fun getCount(): Int
}
