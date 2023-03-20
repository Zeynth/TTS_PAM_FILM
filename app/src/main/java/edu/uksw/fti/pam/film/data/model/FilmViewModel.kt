package edu.uksw.fti.pam.film.data.model

import android.graphics.Movie
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uksw.fti.pam.film.repositories.FilmRepository
import kotlinx.coroutines.launch

class FilmViewModel: ViewModel() {

    private var _filmList = mutableStateListOf<FilmModel>()

    var errorMessage: String by mutableStateOf("")
    val filmList: List<FilmModel>
        get() = _filmList

    fun getFilmList() {
        viewModelScope.launch {
            val apiClient = FilmRepository.getClient()
            try {
                _filmList.clear()
                _filmList.addAll(apiClient.getFilm())
            }
            catch (e: Exception) {
                errorMessage = e.message!!
            }
        }
    }

}

//class FilmViewModel: ViewModel() {
//
//    private val api: FilmRepository = FilmRepository.getClient()
//    var listFilm : List<FilmModel> by mutableStateOf(listOf())
//    var movie : FilmModel? = null
//
//    init {
//        getFilmList()
//    }
//
//    private fun getFilmList() {
//        viewModelScope.launch {
//            try {
//                listFilm = api.getFilm().results
//            }
//            catch (e: Exception) {
//                Log.d("error:", e.message.toString())
//            }
//        }
//    }
//
//    fun getDetailFilm(id: Int) {
//        viewModelScope.launch {
//            try {
//                movie = listFilm.first{it.id == id}
//            }
//            catch (e: Exception) {
//                Log.d("error:", e.message.toString())
//            }
//        }
//    }
//
//}