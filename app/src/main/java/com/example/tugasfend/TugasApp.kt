package com.example.tugasfend

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Topic
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasfend.R
import com.example.tugasfend.navigation.NavigationItem
import com.example.tugasfend.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TugasApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = " MyApp") },
                actions = {
                }
            )
            Icon(
                imageVector = Icons.Outlined.AccountBox,
                contentDescription = "profile",
                tint = Color.Gray,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp)
                    .offset(x =  330.dp)
                    .offset(y = 10.dp)
            )
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
                tint = Color.Gray,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp)
                    .offset(x =  280.dp)
                    .offset(y = 10.dp)
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(Screen.Gallery.route) {
                GalleryScreen()
            }

            composable(Screen.film.route) {
                CourseScreen()
            }

            composable(
                Screen.Detail.route + "/{AktorId}",
                arguments = listOf(navArgument("AktorId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailAktorScreen(
                    navController = navController,
                    aktorId = navBackStackEntry.arguments?.getInt("AktorId")
                )
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_gallery),
                icon = Icons.Default.Category,
                screen = Screen.Gallery
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_film),
                icon = Icons.Default.Topic,
                screen = Screen.film
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_about),
                icon = Icons.Default.People,
                screen = Screen.about
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AppPrev() {
    TugasApp()
}