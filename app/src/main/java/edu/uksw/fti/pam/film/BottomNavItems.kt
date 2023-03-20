package edu.uksw.fti.pam.film

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItems(
    val title: String,
    val icon: ImageVector,
    val screen_route: String
) {
    object Home: BottomNavItems("Home", Icons.Default.Home, "home")
    object Popular: BottomNavItems("Popular", Icons.Default.Favorite, "popular")
    object Search: BottomNavItems("Search", Icons.Default.Search, "search")
    object Profile: BottomNavItems("Profile", Icons.Default.Person, "profile")
}
