package de.theothers.movielist.data

import java.util.*
import javax.inject.Inject


class Movie @Inject constructor() {
    enum class GenreType(val genre: String) {
        ACTION("Action"),
        FANTASY("Fantasy"),
        SCI_FI("Sci-Fi"),
        HORROR("Horror"),
        THRILLER("Thriller"),
        COMEDY("Comedy"),
        DRAMA("Drama")
    }
    val uuid: UUID = UUID.randomUUID()
    var title: String = ""
    var genreList = mutableListOf<GenreType>()
    var description: String = ""
    var duration: Long = 0L
    var rating: Float = 0.0f
}