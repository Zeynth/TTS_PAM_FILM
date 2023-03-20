package edu.uksw.fti.pam.film

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import edu.uksw.fti.pam.film.data.model.DataProvider
import edu.uksw.fti.pam.film.data.model.Film

@Composable
fun DetailScreen(film: Film) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    ProfileHeader(
                        scrollState,
                        film,
                        this@BoxWithConstraints.maxHeight
                    )
                    ProfileContent(film, this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@Composable
private fun ProfileHeader(
    scrollState: ScrollState,
    film: Film,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp),
        painter = rememberImagePainter(
            data = film.filmImage,
        ),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(film: Film, containerHeight: Dp) {
    Column(
        modifier = Modifier
                    .fillMaxSize()
                    .background(Color(20, 26, 49))
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Name(film)

        ProfileProperty(stringResource(R.string.genre), film.genre)

        ProfileProperty(stringResource(R.string.description), film.description)

        // Add a spacer that always shows part (320.dp) of the fields list regardless of the device,
        // in order to always leave some content at the top.
        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

//@Composable
//private fun Name(
//    puppy: Puppy
//) {
//    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
//        Name(
//            puppy = puppy,
////            modifier = Modifier.baselineHeight(32.dp)
//        )
//    }
//}

@Composable
private fun Name(film: Film) {
    Text(
        text = film.title,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        color = Color(238,182,12)
    )
}

@Composable
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = label,
//                modifier = Modifier.baselineHeight(24.dp),
                style = MaterialTheme.typography.caption,
                color = Color(223,168,2)

            )
        }
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.body1
        }
        Text(
            text = value,
//            modifier = Modifier.baselineHeight(24.dp),
            style = style,
                    color = Color.White
        )
    }
}

//@Composable
//fun DetailList(movie: List<FilmModel>, navController: NavController, filmViewModel: FilmViewModel) {
//    if (movie.size>0) {
//        LazyColumn{
//            itemsIndexed(items = movie) {
//                _,
//                    item -> DetailCard(data = item, navController = navController, filmViewModel = filmViewModel)
//            }
//        }
//    }
//}

//@Composable
//fun DetailScreen(model : FilmViewModel, id: Int) {
//    model.getDetailFilm(id=id)
//    val data: FilmModel = model.movie!!
//
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(20.dp)) {
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .height(300.dp)
//            .padding(top = 20.dp), horizontalArrangement = Arrangement.Center) {
//            Image(painter = rememberImagePainter(data.image), contentDescription = data.title)
//        }
//
//        Divider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(vertical = 10.dp))
//    }
//}

@Preview
@Composable
fun ProfilePreview() {
    val film = DataProvider.film
    DetailScreen(film = film)
}