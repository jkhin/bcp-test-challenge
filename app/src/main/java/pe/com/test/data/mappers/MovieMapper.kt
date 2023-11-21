package pe.com.test.data.mappers

import pe.com.test.data.entities.MovieResponse
import pe.com.test.domain.entities.Movie
import pe.com.test.utils.Mapper

class MovieMapper: Mapper<MovieResponse, Movie> {
    override fun map(entry: MovieResponse): Movie {
        return Movie(
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