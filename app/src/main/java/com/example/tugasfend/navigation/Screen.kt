package com.example.tugasfend.navigation

sealed class Screen (val route: String){
    data object Home : Screen("home")
    data object Gallery: Screen("gallery")
    data object film: Screen("film")
    data object Detail: Screen("detail_film")
    data object about : Screen("about")
}