package edu.uksw.fti.pam.film

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import edu.uksw.fti.pam.film.screens.BottomNavigationMainScreenView
import edu.uksw.fti.pam.film.screens.LoginForm
import edu.uksw.fti.pam.film.ui.theme.FilmTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmTheme {
                BottomNavigationMainScreenView()
            }
        }
    }
}
