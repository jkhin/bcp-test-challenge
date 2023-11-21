package pe.com.test.domain.use_cases

import pe.com.test.domain.GetUpcomingMoviesUseCase
import pe.com.test.domain.entities.Movie
import pe.com.test.domain.repositories.MovieRepository

class GetUpcomingMoviesUseCaseImpl(
        private val movieRepository: MovieRepository
    ): GetUpcomingMoviesUseCase {
    override suspend fun get(): List<Movie> {
        return movieRepository.getUpcomingMovies()
    }
}