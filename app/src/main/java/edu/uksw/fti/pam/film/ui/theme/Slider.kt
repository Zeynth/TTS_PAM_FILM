package edu.uksw.fti.pam.film.ui.theme

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import androidx.compose.ui.util.lerp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.uksw.fti.pam.film.MainViewModel
import edu.uksw.fti.pam.film.data.model.Film
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Composable
fun ViewPagerSlider(){

    val pagerState  = rememberPagerState(
        pageCount = MovieBannerList.size,
        initialPage = 0
    )

    LaunchedEffect(Unit){
        while (true){
            Thread.yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            //    .padding(top = 55.dp)
            .height(260.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .weight(1f)
            ) { page ->
                Card(modifier = Modifier
                    .background(Color.Black)
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )

                    }
                    .fillMaxWidth()
                ) {

                    val imageBanner = MovieBannerList[page]

                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(260.dp),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Image(
                                painter = painterResource(
                                    id = imageBanner.imgUri
                                ),
                                contentDescription = "Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(260.dp),
                            )
                            HorizontalPagerIndicator(
                                pagerState = pagerState,
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(16.dp),
                                Color.White,
                                Color.DarkGray,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Header()
{
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 280.dp)
                //.padding(start = 20.dp)
                //.padding(end = 20.dp)
                //.background(color = Color(0,16,66)),
                .background(Color(0,15,60)),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 20.dp),
                text = "Featured today",
                color = Color(238, 182, 12),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
}

@Composable
fun TopBox()
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 550.dp)
//            .padding(start = 20.dp)
//            .padding(end = 20.dp)
            .background(Color(0,15,60)),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(start = 20.dp),
            text = "Top box office",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .padding(start = 20.dp),
            text = "Weekend of March 17-19",
            color = Color(130, 130, 130),
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic
        )
        Text(
            modifier = Modifier
                .padding(start = 18.dp),
            text = "1. Shazam! Fury of the Gods",
            color = Color.White,
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 40.dp),
            text = "$30.5M",
            color = Color(130, 130, 130),
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 18.dp),
            text = "2. Scream VI",
            color = Color.White,
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 40.dp),
            text = "$17.5M",
            color = Color(130, 130, 130),
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 18.dp),
            text = "3. Creed III",
            color = Color.White,
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 40.dp),
            text = "$15.3M",
            color = Color(130, 130, 130),
            fontSize = 18.sp
        )
    }
}