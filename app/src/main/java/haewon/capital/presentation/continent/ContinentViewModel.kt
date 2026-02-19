package haewon.capital.presentation.continent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import capital.domain.model.ContinentStat
import capital.domain.usecase.GetContinentStatsUseCase
import capital.domain.usecase.InitializeDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContinentViewModel @Inject constructor (
    private val initializeDataUseCase: InitializeDataUseCase,
    private val getContinentStatsUseCase: GetContinentStatsUseCase
) : ViewModel() {
    private val _stats = MutableStateFlow<List<ContinentStat>>(emptyList())
    val stats = _stats.asStateFlow()

    init {
        viewModelScope.launch {
            initializeDataUseCase()
            getContinentStatsUseCase().collect { _stats.value = it }
        }
    }
}