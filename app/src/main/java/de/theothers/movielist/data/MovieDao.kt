package de.theothers.movielist.data

import java.util.*
import kotlin.collections.HashMap

class MovieDao {

    private val mockDatabase: HashMap<UUID, Movie> = HashMap()

    init {
        createMockData().forEach { movie -> mockDatabase[movie.uuid] = movie }
    }

    private fun createMockData():List<Movie> {
        val movieList = mutableListOf<Movie>()
        movieList.add(MovieFactory.makeMovie(SampleData.HARRY_POTTER))
        movieList.add(MovieFactory.makeMovie(SampleData.TRIBUTE_OF_PANEM))
        return movieList
    }

    fun updateMovieRating(id: UUID, rating: Float): Movie? {
        mockDatabase[id]?.rating = rating
        return mockDatabase[id]
    }

    fun getMovie(id: UUID): Movie? {
        return mockDatabase[id]
    }

    fun getAllMovies(): List<Movie> {
        return ArrayList(mockDatabase.values)
    }
}