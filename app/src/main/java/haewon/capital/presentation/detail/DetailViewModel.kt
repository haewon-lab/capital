package haewon.capital.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import capital.domain.model.Country
import capital.domain.usecase.GetCountryDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCountryDetailUseCase: GetCountryDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _country = MutableStateFlow<Country?>(null)
    val country = _country.asStateFlow()

    init {
        val code = savedStateHandle.get<String>("countryCode") ?: ""
        viewModelScope.launch {
            getCountryDetailUseCase(code).collect { _country.value = it }
        }
    }
}