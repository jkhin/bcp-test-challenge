package pe.com.test.data.entities

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val id: Int,
    val popularity: Double,
    val overview: String,
    val video: Boolean,
    val title: String,
    val adult: Boolean,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
)