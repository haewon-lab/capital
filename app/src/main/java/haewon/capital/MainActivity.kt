package haewon.capital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import haewon.capital.navigation.Screen
import haewon.capital.presentation.continent.ContinentScreen
import haewon.capital.presentation.detail.DetailScreen
import haewon.capital.presentation.list.CountryListScreen
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Screen.Continent.route) {

                composable(Screen.Continent.route) {
                    ContinentScreen(
                        onContinentClick = { continent ->
                            navController.navigate(Screen.CountryList.createRoute(continent))
                        }
                    )
                }

                composable(
                    route = Screen.CountryList.route,
                    arguments = listOf(navArgument("continent") { type = NavType.StringType })
                ) {
                    CountryListScreen(
                        onContinentClick = { code ->
                            navController.navigate(Screen.Detail.createRoute(code))
                        }
                    )
                }

                composable(
                    route = Screen.Detail.route,
                    arguments = listOf(navArgument("countryCode") { type = NavType.StringType })
                ) {
                    DetailScreen()
                }
            }
        }
    }
}