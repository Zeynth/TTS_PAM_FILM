package edu.uksw.fti.pam.film.data.model

import com.google.gson.annotations.SerializedName

data class DataFilm(
    val results : List<FilmModel>
)

data class FilmModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("desc")
    val desc: String,

    @SerializedName("genre")
    val genre: String

)
