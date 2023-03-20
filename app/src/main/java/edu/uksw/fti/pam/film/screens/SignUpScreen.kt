package edu.uksw.fti.pam.film.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import edu.uksw.fti.pam.film.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.uksw.fti.pam.film.data.StoreName
import edu.uksw.fti.pam.film.ui.theme.FilmTheme
import kotlinx.coroutines.launch

@Composable
fun SignUpForm(btnOnClickAction: (String?) -> Unit) {
    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var confirmpasswordInput by remember { mutableStateOf("") }
    //context
    val context = LocalContext.current
    //scope
    val scope = rememberCoroutineScope()
    //datastore Email
    val dataStore = StoreName(context)
    //ambil data
    val savedFName = dataStore.getFName.collectAsState(initial = "")
    var fname by remember { mutableStateOf("") }
    val savedLName = dataStore.getLName.collectAsState(initial = "")
    var lname by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(20, 26, 49))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp)
                .padding(20.dp, 40.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(0.dp, 30.dp),
                color = Color.White,
                text = stringResource(id = R.string.createacc),
                fontSize = 30.sp,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                Arrangement.SpaceBetween
            ) {
                TextField(
                    value = fname,
                    onValueChange = { fname = it },
                    label = { Text(text = stringResource(id = R.string.fname)) },
                    modifier = Modifier.width(175.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedLabelColor = Color.White,
                        backgroundColor = Color(8,16,41)
                    ),textStyle = LocalTextStyle.current.copy(color = Color.White)
                )
                TextField(
                    value = lname,
                    onValueChange = { lname = it },
                    label = { Text(text = stringResource(R.string.lname)) },
                    modifier = Modifier.width(175.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedLabelColor = Color.White,
                        backgroundColor = Color(8,16,41)
                    ),textStyle = LocalTextStyle.current.copy(color = Color.White)
                )
            }

            TextField(
                value = usernameInput,
                onValueChange = { usernameInput = it },
                label = { Text(text = stringResource(R.string.username)) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedLabelColor = Color.White,
                    backgroundColor = Color(8,16,41)
                ),textStyle = LocalTextStyle.current.copy(color = Color.White)
            )
            TextField(
                value = passwordInput,
                onValueChange = { passwordInput = it },
                label = { Text(text = stringResource(R.string.password)) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedLabelColor = Color.White,
                    backgroundColor = Color(8,16,41)
                ),textStyle = LocalTextStyle.current.copy(color = Color.White)
            )
            TextField(
                value = confirmpasswordInput,
                onValueChange = { confirmpasswordInput = it },
                label = { Text(text = stringResource(R.string.confirmpassword)) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedLabelColor = Color.White,
                    backgroundColor = Color(8,16,41),
                ),textStyle = LocalTextStyle.current.copy(color = Color.White)
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    btnOnClickAction(usernameInput)
                    scope.launch {
                        dataStore.saveFName(fname)
                        dataStore.saveLName(lname)
                    }
                }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(238,182,12)),
                shape = RoundedCornerShape(50)

            ) {
                Text(text = stringResource(R.string.signup))
            }
        }
    }
}

@Composable
fun SignUpFormPreview(navController: NavController) {
    FilmTheme() {
        SignUpForm({})
    }
}