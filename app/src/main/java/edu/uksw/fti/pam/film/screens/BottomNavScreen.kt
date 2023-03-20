package edu.uksw.fti.pam.film.screens

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.uksw.fti.pam.film.FilmContent
import edu.uksw.fti.pam.film.BottomNavItems
import edu.uksw.fti.pam.film.DetailActivity

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    val lcontext = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = BottomNavItems.Home.screen_route
    ) {
        composable(BottomNavItems.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItems.Popular.screen_route) {
            FilmContent {
                lcontext.startActivity(DetailActivity.newIntent(lcontext, it))
            }
        }
        composable(BottomNavItems.Search.screen_route) {
            SearchScreen {
                lcontext.startActivity(DetailActivity.newIntent(lcontext, it))
            }
        }
        composable(BottomNavItems.Profile.screen_route) {
            ProfileScreen{}
        }
    }
}

@Composable
fun BottomNavigation(
    navController: NavController
){
    val items = listOf(
        BottomNavItems.Home,
        BottomNavItems.Popular,
        BottomNavItems.Search,
        BottomNavItems.Profile
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = Color(8,16,41),
        contentColor = MaterialTheme.colors.onPrimary,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "${item.title} icon")
                },
                label = {
                    Text(text = item.title,
                        fontSize = 9.sp)
                },
                selectedContentColor = MaterialTheme.colors.onPrimary,
                unselectedContentColor = MaterialTheme.colors.onPrimary.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationMainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = navController,
            )
        }
    ) {
        NavigationGraph(navController = navController)
    }
}