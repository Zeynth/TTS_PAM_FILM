package edu.uksw.fti.pam.film.ui.theme

import edu.uksw.fti.pam.film.R

data class MovieBanner(
    val imgUri:Int
)

val MovieBannerList = listOf(
    MovieBanner(
        R.drawable.mariobanner
    ),
    MovieBanner(
        R.drawable.spiderbanner
    ),
    MovieBanner(
        R.drawable.marvelbanner
    )
)
