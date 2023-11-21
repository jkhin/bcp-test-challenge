package pe.com.test.domain.use_cases

import pe.com.test.domain.GetPopularMoviesUseCase
import pe.com.test.domain.entities.Movie
import pe.com.test.domain.repositories.MovieRepository

class GetPopularMoviesUseCaseImpl(
        private val movieRepository: MovieRepository
    ): GetPopularMoviesUseCase {
    override suspend fun get(): List<Movie> {
        return movieRepository.getPopularMovies()
    }
}