package pe.com.test.domain.repositories

import pe.com.test.domain.entities.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getUpcomingMovies(): List<Movie>
}