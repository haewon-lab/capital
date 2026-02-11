package capital.domain.usecase

import capital.domain.model.Country
import capital.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCountryDetailUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(code: String): Flow<Country> {
        return repository.getCountryDetail(code)
    }
}