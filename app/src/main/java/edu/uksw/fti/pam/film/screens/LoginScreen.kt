package edu.uksw.fti.pam.film.screens

import android.content.Intent
import android.graphics.Paint.Align
import android.graphics.Paint.Style
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.uksw.fti.pam.film.contract.SignUpContract
import edu.uksw.fti.pam.film.ui.theme.FilmTheme
import edu.uksw.fti.pam.film.HomeActivity
import edu.uksw.fti.pam.film.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

internal fun doAuth(
    username: String,
    password: String,
): Boolean {
    return (username.equals("admin") && password.equals("admin"))
}

@Composable
fun LoginForm() {
    val lContext = LocalContext.current

    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    val getUsernameFromSignedUpForm = rememberLauncherForActivityResult(
        contract = SignUpContract(),
        onResult = { usernameInput = it!!})


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(20,26,49))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.cinemate),
                contentDescription = "Manga Logo",
                modifier = Modifier
                        .size(width = 250.dp, height = 250.dp),
            )

            TextField(
                    value = usernameInput,
                    onValueChange = { usernameInput = it },
                    label = { Text(text = stringResource(R.string.username)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedLabelColor = Color.White,
                        backgroundColor = Color(8,16,41),
                    ),textStyle = LocalTextStyle.current.copy(color = Color.White)

            )
            TextField(
                    value = passwordInput,
                    onValueChange = { passwordInput = it },
                    label = { Text(text = stringResource(R.string.password)) },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedLabelColor = Color.White,
                        backgroundColor = Color(8,16,41)
                    ),textStyle = LocalTextStyle.current.copy(color = Color.White)
            )

            Text(
                modifier = Modifier
                    .padding(start = 250.dp),
                text = stringResource(R.string.forgetpassword),
                style = TextStyle(color = Color.Gray),
            )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),

                    onClick = {
                        val isAuthtenticated = doAuth(usernameInput, passwordInput)
                        if (isAuthtenticated) {
                            lContext.startActivity(
                                Intent(lContext, HomeActivity::class.java)
                                    .apply {
                                        putExtra("username", usernameInput)
                                    }
                            )
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(238,182,12))
                ) {
                    Text(text = stringResource(R.string.login))
                }

                TextButton(
                    onClick = {
                        getUsernameFromSignedUpForm.launch("")
                    }
                ) {
                    Text(
                        text = stringResource(R.string.noacc),
                        style = TextStyle(color = Color.Gray)
                    )
                    Text(text = stringResource(R.string.signup),
                        style = TextStyle(color = Color.White)
                    )
                }
            }
        }
    }
