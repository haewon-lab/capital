package capital.domain.repository

import capital.domain.model.ContinentStat
import capital.domain.model.Country
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    suspend fun initializeData()

    fun getContinentStats(): Flow<List<ContinentStat>>
    fun getCountriesByContinent(continent: String): Flow<List<Country>>
    fun getCountryDetail(code: String): Flow<Country>
}