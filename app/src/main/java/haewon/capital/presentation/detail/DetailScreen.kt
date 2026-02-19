package haewon.capital.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailScreen (
    viewModel: DetailViewModel = hiltViewModel()
) {
    val country by viewModel.country.collectAsStateWithLifecycle()

    country?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = it.nameKo, style = MaterialTheme.typography.headlineLarge)
            Text(text = "수도: ${it.capitals.joinToString { cap -> cap.koreaName }}")
            Text(text = "언어: ${it.languages.joinToString()}")
        }
    } ?: Text("로딩 중...")
}