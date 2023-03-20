package edu.uksw.fti.pam.film.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Film(
    val id: Int,
    val title: String,
    val genre: String,
    val description: String,

    @SerializedName("filmImage")
    val filmImage: String
) : Serializable {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$title",
            "${title.first()}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}
