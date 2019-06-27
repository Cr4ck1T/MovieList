package de.theothers.movielist.data

import java.time.Duration

enum class SampleData(val title: String, val description: String, val duration: Long, val rating:Float, val genre: List<Movie.GenreType>) {
    HARRY_POTTER(
        "Harry Potter is a British-American film series based on the eponymous novels by author J. K. Rowling.",
        "Harry Potter is an orphaned boy brought up by his unkind Muggle (non-magical) aunt and uncle...",
        9120000L,
        4.7f,
        listOf(Movie.GenreType.FANTASY)
        ),
    TRIBUTE_OF_PANEM(
        "The Hunger Games",
        "he Hunger Games follows 16-year-old Katniss Everdeen, a girl from District 12 who volunteers for the 74th Hunger Games in place of her younger sister Primrose Everdeen. Also selected from District 12 is Peeta Mellark. They are mentored by their district's only living victor, Haymitch Abernathy, who won 24 years earlier and has since led a solitary life of alcoholism.",
        8520000,
        3.6f,
        listOf(Movie.GenreType.SCI_FI, Movie.GenreType.ACTION )
        )

}