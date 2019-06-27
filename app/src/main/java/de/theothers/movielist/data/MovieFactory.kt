package de.theothers.movielist.data

class MovieFactory {
    companion object{
        fun makeMovie(movieData: SampleData):Movie{
            val movie = Movie()
            movie.title = movieData.title
            movie.description = movieData.description
            movie.duration = movieData.duration
            movie.rating = movieData.rating
            movie.genreList = movieData.genre.toMutableList()
            return movie
        }
    }
}