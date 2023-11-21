package pe.com.test.domain

import pe.com.test.domain.entities.Movie

interface GetPopularMoviesUseCase {
    suspend fun get(): List<Movie>
}