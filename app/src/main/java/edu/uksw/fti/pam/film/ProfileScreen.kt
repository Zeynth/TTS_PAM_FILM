package edu.uksw.fti.pam.film

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import edu.uksw.fti.pam.film.screens.BottomNavigationMainScreenView
import edu.uksw.fti.pam.film.ui.theme.FilmTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmTheme {
                BottomNavigationMainScreenView()
            }
        }
    }
}