package de.theothers.movielist.data

import org.hamcrest.CoreMatchers.*
import org.hamcrest.core.Is
import org.hamcrest.core.IsInstanceOf
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.*

class MovieTest {
    companion object {
        private const val TITLE = "The Test Movie"
        private const val DESCRIPTION = "The movie is about unit testing on Android."
        private const val DURATION = 1_50_00_00L
        private const val RATING = 4.6f

    }

    private lateinit var movie: Movie
    @Before
    fun setUp() {
        movie = Movie()
    }

    @Test
    fun getUUID() {
        assertThat(movie.uuid, IsInstanceOf(UUID::class.java))
    }

    @Test
    fun getEmptyTitle() {
        assertTrue(movie.title.isEmpty())
    }

    @Test
    fun setAndGetTitle() {
        movie.title = TITLE
        assertThat(movie.title, Is(equalTo(TITLE)))
    }

    @Test
    fun getEmptyGenreList() {
        assertTrue(movie.genreList.isNullOrEmpty())
    }

    @Test
    fun setAndGetGenreList() {
        movie.genreList.add(Movie.GenreType.HORROR)
        movie.genreList.add(Movie.GenreType.THRILLER)
        movie.genreList.add(Movie.GenreType.DRAMA)
        assertThat(movie.genreList, hasItem(Movie.GenreType.DRAMA))
        assertThat(movie.genreList, hasItem(Movie.GenreType.THRILLER))
        assertThat(movie.genreList, hasItem(Movie.GenreType.HORROR))
        assertThat(movie.genreList, not(hasItem(Movie.GenreType.COMEDY)))
    }

    @Test
    fun getEmptyDescription() {
        assertTrue(movie.description.isEmpty())
    }

    @Test
    fun setAndGetDescription() {
        movie.description = DESCRIPTION
        assertThat(movie.description, Is(equalTo(DESCRIPTION)))
    }

    @Test
    fun getDefaultDuration() {
        assertThat(movie.duration, Is(equalTo(0L)))
    }

    @Test
    fun setAndGetDuration() {
        movie.duration = DURATION
        assertThat(movie.duration, Is(equalTo(DURATION)))
    }

    @Test
    fun getDefaultRating() {
        assertThat(movie.rating, Is(equalTo(0.0f)))
    }

    @Test
    fun setAndGetRating() {
        movie.rating = RATING
        assertThat(movie.rating, Is(equalTo(RATING)))
    }
}