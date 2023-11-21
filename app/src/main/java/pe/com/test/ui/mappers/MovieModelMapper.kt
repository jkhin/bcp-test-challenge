package pe.com.test.ui.mappers

import pe.com.test.domain.entities.Movie
import pe.com.test.ui.models.MovieModel
import pe.com.test.utils.Mapper

class MovieModelMapper: Mapper<Movie, MovieModel> {
    override fun map(entry: Movie): MovieModel {
        return MovieModel(
            id = entry.id,
            popularity = entry.popularity,
            overview = entry.overview,
            title = entry.title,
            voteCount = entry.voteCount,
            backdropPath = entry.backdropPath,
            originalLanguage = entry.originalLanguage,
            posterPath = entry.posterPath
        )
    }
}