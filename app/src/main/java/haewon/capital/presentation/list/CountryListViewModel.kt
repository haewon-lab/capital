package haewon.capital.presentation.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import capital.domain.model.Country
import capital.domain.usecase.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _countries = MutableStateFlow<List<Country>>(emptyList())

    val countries = _countries.asStateFlow()

    init {
        // 네비게이션으로 넘어온 'continent' 값 꺼내기
        val continent = savedStateHandle.get<String>("continent") ?: ""
        fetchCountries(continent)
    }

    private fun fetchCountries(continent: String) {
        viewModelScope.launch {
            getCountriesUseCase(continent).collect { _countries.value = it }
        }
    }
}