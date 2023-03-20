package edu.uksw.fti.pam.film

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import edu.uksw.fti.pam.film.data.model.Film
import edu.uksw.fti.pam.film.ui.theme.FilmTheme

class DetailActivity : AppCompatActivity() {

    private val film: Film by lazy {
        intent?.getSerializableExtra(FILM_ID) as Film
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmTheme() {
                DetailScreen(film)
            }
        }
    }

    companion object {
        private const val FILM_ID = "film_id"
        fun newIntent(context: Context, film: Film) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(FILM_ID, film)
            }
    }
}