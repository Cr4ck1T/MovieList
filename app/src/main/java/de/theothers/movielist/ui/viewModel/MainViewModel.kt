package de.theothers.movielist.ui.viewModel

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import de.theothers.movielist.data.Movie
import de.theothers.movielist.data.MovieRepository
import de.theothers.movielist.ui.viewModel.MovieCardViewModel.Companion.DEFAULT_RATING
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class MainViewModel(private val repository: MovieRepository) : ViewModel() {
    private var isRandomizeRatingsEnabled: Boolean = false
    private val movieList = repository.getAllMoviesAsLiveData()
    private val uiScope = CoroutineScope(Dispatchers.Main)

    fun getMovies(notifyAdapter: (movies: List<MovieCardViewModel>) -> Unit) {
        movieList.observeForever(Observer {

        })
        val movies = mutableListOf<MovieCardViewModel>()
        movieList.value?.forEach { movie -> movies.add(MovieCardViewModel(movie, ::changeRating)) }
        notifyAdapter(movies)
    }

    private fun changeRating(movie: Movie, rating: Float) {
       val movieFromList =movieList.value?.find { it.uuid == movie.uuid }
        movieFromList?.rating = repository.setRating(movie, rating)?.rating ?: DEFAULT_RATING
        
    }

    fun randomizeRatings() {
        isRandomizeRatingsEnabled = !isRandomizeRatingsEnabled
        uiScope.launch {
            while (isRandomizeRatingsEnabled) {
                delay(Random.nextLong(ONE_SECOND, 5 * ONE_SECOND))
                getRandomMovie()?.let { changeRating(it, getRandomRating()) }
            }
        }

    }

    private fun getRandomRating(): Float {
        return Random.nextFloat() * 5
    }

    private fun getRandomMovie(): Movie? {
        return movieList.value?.get(Random.nextInt(0, movieList.value?.size ?: 1 - 1))
    }

    companion object {
        const val ONE_SECOND = 1000L
    }
}
