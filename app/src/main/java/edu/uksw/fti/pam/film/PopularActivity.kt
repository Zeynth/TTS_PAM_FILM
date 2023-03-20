package edu.uksw.fti.pam.film

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import edu.uksw.fti.pam.film.data.model.Film
import edu.uksw.fti.pam.film.ui.theme.FilmTheme

class PopularActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmTheme {
            }
            MyApp {
//                    startActivity(Intent(this, DetailActivity::class.java))
                startActivity(DetailActivity.newIntent(this, it))
//                    ContextCompat.startActivity(DetailActivity.newIntent(this, it))
            }
        }
    }
}

@Composable
fun MyApp(navigateToProfile: (Film) -> Unit) {
    Scaffold(
        content = {
            FilmContent(navigateToProfile = navigateToProfile)
        }
    )
}