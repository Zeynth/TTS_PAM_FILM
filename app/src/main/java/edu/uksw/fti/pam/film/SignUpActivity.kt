package edu.uksw.fti.pam.film

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import edu.uksw.fti.pam.film.screens.SignUpForm
import edu.uksw.fti.pam.film.ui.theme.FilmTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    SignUpForm(::sendUsernameBackToLogin)
                }
            }
        }
    }
    private fun sendUsernameBackToLogin(username: String?) {
        val result = Intent().putExtra("username", username)
        setResult(Activity.RESULT_OK, result)
        finish()
    }
}