package capital.domain.usecase

import capital.domain.model.ContinentStat
import capital.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetContinentStatsUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(): Flow<List<ContinentStat>> {
        return repository.getContinentStats()
    }
}