package capital.domain.usecase

import capital.domain.model.Country
import capital.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(continent: String): Flow<List<Country>> {
        return repository.getCountriesByContinent(continent)
    }
}