package capital.data.repository

import capital.data.local.dao.CountryDao
import capital.data.mapper.toDomain
import capital.data.mapper.toEntity
import capital.data.source.AssetDataSource
import capital.domain.model.ContinentStat
import capital.domain.model.Country
import capital.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countryDao: CountryDao,
    private val assetDataSource: AssetDataSource
) : CountryRepository {
    override suspend fun initializeData() {
        if (countryDao.getCount() == 0) {
            val jsonList = assetDataSource.getCountryData()
            val entities = jsonList.map { it.toEntity() }
            countryDao.insertAll(entities)
        }
    }

    override fun getContinentStats(): Flow<List<ContinentStat>> {
        return countryDao.getContinentStats().map { list ->
            list.map { ContinentStat(it.continent, it.count) }
        }
    }

    override fun getCountriesByContinent(continent: String): Flow<List<Country>> {
        return countryDao.getCountriesByContinent(continent).map { list ->
            list.map { it.toDomain() }
        }
    }

    override fun getCountryDetail(code: String): Flow<Country> {
        return countryDao.getCountryDetail(code).map { it.toDomain() }
    }
}