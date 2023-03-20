package edu.uksw.fti.pam.film.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.uksw.fti.pam.film.MainViewModel
import edu.uksw.fti.pam.film.data.model.DataProvider
import edu.uksw.fti.pam.film.data.model.Film
import edu.uksw.fti.pam.film.ui.theme.FilmListItem

@Composable
fun SearchScreen(navigateToProfile: (Film) -> Unit) {
    val puppies = remember { DataProvider.filmList }
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val persons by viewModel.persons.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(20,26,49))
    ) {
        TextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = Color.Black,
                backgroundColor = Color.White

            ),
            placeholder = { Text(text = "Search") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if(isSearching) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(persons, itemContent = {
                    FilmListItem(film = it, navigateToProfile)
                })
//                    this@LazyColumn.items(
//                        items = persons,
//                        itemContent = {
//                            PuppyListItem(puppy = it, navigateToProfile)
//                        }
//                    )
//                    Text(
//                        text = "${person.title}",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 16.dp)
//                            .clickable { navigateToProfile(puppy) },
//                        itemContent = {
//                            PuppyListItem(puppy = it, navigateToProfile)
//                        }
//                    )
//                }
            }
        }
    }
}