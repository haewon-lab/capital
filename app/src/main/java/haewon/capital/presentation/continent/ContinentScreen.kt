package haewon.capital.presentation.continent

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ContinentScreen(
    viewModel: ContinentViewModel = hiltViewModel(),
    onContinentClick: (String) -> Unit
) {
    val stats by viewModel.stats.collectAsStateWithLifecycle()

    LazyColumn {
        items(stats) { stat ->
            Text(
                text = "${stat.continent} (${stat.count})",
                modifier = Modifier.clickable { onContinentClick(stat.continent) }
            )
        }
    }
}