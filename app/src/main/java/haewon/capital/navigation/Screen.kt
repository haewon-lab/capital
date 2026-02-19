package haewon.capital.navigation

sealed class Screen(val route: String) {
    data object Continent : Screen("continent_screen")
    data object CountryList : Screen("country_list_screen/{continent}") {
        fun createRoute(continent: String) = "country_list_screen/$continent"
    }
    data object Detail : Screen("detail_screen/{countryCode}") {
        fun createRoute(code: String) = "detail_screen/$code"
    }
}