package pe.com.test.domain.entities

data class Movie(
    val id: Int,
    val popularity: Double,
    val overview: String,
    val title: String,
    val voteCount: Int,
    val backdropPath: String?,
    val originalLanguage: String,
    val posterPath: String,
)
