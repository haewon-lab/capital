package capital.domain.usecase

import capital.domain.repository.CountryRepository
import javax.inject.Inject

class InitializeDataUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    suspend operator fun invoke() {
        repository.initializeData()
    }
}