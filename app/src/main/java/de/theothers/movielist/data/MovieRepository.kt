package de.theothers.movielist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

class MovieRepository {
    private val dao: MovieDao = MovieDao()

    fun getMovieAsLiveData(id: UUID): LiveData<Movie> {
        return MutableLiveData<Movie>().apply { dao.getMovie(id) }
    }

    fun getAllMoviesAsLiveData(): LiveData<List<Movie>> {
        return MutableLiveData<List<Movie>>().apply { dao.getAllMovies() }
    }

    fun setRating(movie: Movie, rating: Float): Movie? {
        return dao.updateMovieRating(movie.uuid, rating)
    }
}