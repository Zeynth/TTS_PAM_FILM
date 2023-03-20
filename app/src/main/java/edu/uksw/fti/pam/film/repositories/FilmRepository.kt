package edu.uksw.fti.pam.film.repositories

import edu.uksw.fti.pam.film.data.model.DataFilm
import edu.uksw.fti.pam.film.data.model.FilmModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FilmRepository {

    @GET("Popular")
    suspend fun getFilm(): List<FilmModel>

    companion object {
        var _apiClient: FilmRepository? = null

        fun getClient(): FilmRepository {
            if (_apiClient == null) {
                _apiClient = Retrofit.Builder()
                    .baseUrl("https://my-json-server.typicode.com/Zeynth/Film/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(FilmRepository::class.java)
            }

            return _apiClient!!
        }
    }

}