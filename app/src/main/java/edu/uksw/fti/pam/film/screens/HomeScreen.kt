package edu.uksw.fti.pam.film.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import edu.uksw.fti.pam.film.data.model.FilmModel
import edu.uksw.fti.pam.film.data.model.FilmViewModel
import edu.uksw.fti.pam.film.ui.theme.*

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(20, 26, 49))
    )
    val fvm = FilmViewModel()
    FilmTheme {
        TopBox()
        ViewPagerSlider()
        MainScreenView(fvm)
    }
}

@Composable
fun MainScreenView(
    fvm: FilmViewModel
) {
    LaunchedEffect(
        Unit,
        block = {
            fvm.getFilmList()
        }
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 270.dp)
            .background(Color(0, 15, 60)),
    ) {
        Text(
            modifier = Modifier
                .padding(start = 20.dp),
            text = "Featured today",
            color = Color(238, 182, 12),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        when {
            fvm.errorMessage.isEmpty() -> FvmList(fvl = fvm.filmList)
            else -> Log.e("FVM", "Something happened")
        }

    }

}

@Composable
fun FvmList(fvl: List<FilmModel>) {
//    Box(modifier = Modifier
//        .fillMaxWidth()
//        .padding(10.dp)
//    ) {

    LazyRow(modifier = Modifier
        .fillMaxWidth(),
        state = rememberLazyListState()
    ) {
        items(fvl){item ->

            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .height(190.dp)
                    .width(110.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(49, 49, 49).copy(alpha = 0.4f))
                    .clickable { },
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(49, 49, 49)),
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = item.image,
//                                builder = {
//                                    scale(Scale.FILL)
//                                    placeholder(R.drawable.notification_action_background)
//                                    transformations(CircleCropTransformation())
//                                }
                        ),
                        contentDescription = item.desc,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .clip(RoundedCornerShape(5.dp)),
//                                .weight(0.2f)
                    )

                }

                Text(
                    text = item.title,
                    color = Color.White,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}