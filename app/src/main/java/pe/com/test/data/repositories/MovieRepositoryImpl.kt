package pe.com.test.data.repositories

import pe.com.test.data.mappers.MovieMapper
import pe.com.test.data.remote.MovieCloudDataSource
import pe.com.test.domain.entities.Movie
import pe.com.test.domain.repositories.MovieRepository

class MovieRepositoryImpl(
        private val movieCloudDataSource: MovieCloudDataSource,
        private val movieMapper: MovieMapper,
    ): MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        val response = movieCloudDataSource.getPopularMovies()
        return response.results.map { movieMapper.map(it) }
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        val response = movieCloudDataSource.getUpcomingMovies()
        return response.results.map { movieMapper.map(it) }
    }
}