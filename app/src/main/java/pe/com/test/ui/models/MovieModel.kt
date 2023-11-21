package pe.com.test.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel(
    val id: Int,
    val popularity: Double,
    val overview: String,
    val title: String,
    val voteCount: Int,
    val backdropPath: String?,
    val originalLanguage: String,
    val posterPath: String,
) : Parcelable
