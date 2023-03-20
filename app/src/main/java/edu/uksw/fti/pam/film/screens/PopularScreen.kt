package edu.uksw.fti.pam.film

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import edu.uksw.fti.pam.film.data.model.DataProvider
import edu.uksw.fti.pam.film.data.model.Film
import edu.uksw.fti.pam.film.ui.theme.FilmListItem

@Composable
fun FilmContent(navigateToProfile: (Film) -> Unit) {
    val films = remember { DataProvider.filmList }
    LazyColumn(
        modifier = Modifier.background(Color(20,26,49)),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = films,
            itemContent = {
                FilmListItem(film = it, navigateToProfile, )
            }
        )
    }
}