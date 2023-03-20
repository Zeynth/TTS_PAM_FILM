package edu.uksw.fti.pam.film.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.uksw.fti.pam.film.R
import edu.uksw.fti.pam.film.data.StoreName
import edu.uksw.fti.pam.film.ui.theme.FilmTheme

@Composable
fun ProfileScreen(function: () -> Unit) {
    //context
    val context = LocalContext.current
    //scope
    val scope = rememberCoroutineScope()
    //datastore Email
    val dataStore = StoreName(context)
    //memeunculkan data
    val savedFName = dataStore.getFName.collectAsState(initial = "")
    var fname by remember { mutableStateOf("") }
    val savedLName = dataStore.getLName.collectAsState(initial = "")
    var lname by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(20, 26, 49))
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 120.dp, start = 10.dp, end = 10.dp)
            .background(color = Color(8, 16, 41), RoundedCornerShape(50.dp))
    )
    Column( modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.profilelindan),
            contentDescription = "Manga Logo",
            modifier = Modifier
                .padding(top = 40.dp)
                .size(width = 120.dp, height = 120.dp),
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        ) {
            Text(
                text = savedFName.value!!,
                color = Color.White,
                textAlign = TextAlign.Center ,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    fontSize = 18.sp,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = savedLName.value!!,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    fontSize = 18.sp,
                    color = Color.White
                )
            )
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 30.dp, end = 30.dp),
                elevation = 4.dp,
                backgroundColor = Color(30,39,70),
                shape = RoundedCornerShape(30)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,

                    ) {
                    Column {
                    Text(
                        text = "Edit Profile",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    )
                }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 30.dp, end = 30.dp),
                elevation = 4.dp,
                backgroundColor = Color(30,39,70),
                shape = RoundedCornerShape(30)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,

                    ) {
                    Column {
                    Text(
                        text = "Setting",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    )
                }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 30.dp, end = 30.dp),
                elevation = 4.dp,
                backgroundColor = Color(30,39,70),
                shape = RoundedCornerShape(30)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,

                    ) {
                    Column {
                    Text(
                        text = "About",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    )
                }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 30.dp, end = 30.dp),
                elevation = 4.dp,
                backgroundColor = Color(30,39,70),
                shape = RoundedCornerShape(30)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                        .clip(RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center,


                    ) {
                    Column {
                    Text(
                        text = "Log Out",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    )
                }
                }
            }
        }
    }
}


@Composable
fun ProfilePreview(navController: NavController) {
    FilmTheme() {
        ProfileScreen {}
    }
}