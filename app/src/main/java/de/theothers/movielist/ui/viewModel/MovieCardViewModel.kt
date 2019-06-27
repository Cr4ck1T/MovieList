package de.theothers.movielist.ui.viewModel

import android.media.Rating
import androidx.lifecycle.MutableLiveData
import de.theothers.movielist.data.Movie
import java.util.concurrent.TimeUnit

class MovieCardViewModel(val movie: Movie, onChangeMovieRating:(movie: Movie, rating:Float) -> Unit) {
    val title = MutableLiveData<String>().apply { value = movie.title }
    val description = MutableLiveData<String>().apply { value = movie.description }
    val genre = MutableLiveData<String>().apply { value = movie.genreList.joinToString(",", " ") }
    val rating = MutableLiveData<Float>().apply { value = movie.rating }
    val duration = MutableLiveData<String>().apply {
        value = "${TimeUnit.MILLISECONDS.toMinutes(movie.duration)} Min."

        fun onRatingChanged(){
            onChangeMovieRating(movie, rating.value ?: DEFAULT_RATING)
        }

        fun updateMovieRating(newRating:Float ){
            rating.value = newRating
        }
    }

    companion object{
        const val DEFAULT_RATING = 0.0f
    }
}