package pe.com.test.data.remote

import pe.com.test.data.entities.BaseResponse
import pe.com.test.data.remote.api.MovieService
import pe.com.test.data.remote.base.CloudDataSource

class MovieCloudDataSourceImpl(
    private val movieService: MovieService
) : CloudDataSource(), MovieCloudDataSource {

    override suspend fun getPopularMovies(): BaseResponse {
        return getResult {
            movieService.popularMovies(API_KEY, PAGE, LANGUAGE)
        }
    }

    override suspend fun getUpcomingMovies(): BaseResponse {
        return getResult {
            movieService.upcomingMovies(API_KEY, PAGE, LANGUAGE)
        }
    }

    companion object {
        private const val API_KEY = "d9ae4921794c06bd0fdbd1463d274804"
        private const val LANGUAGE = "en-US"
        private const val PAGE = "1"
    }

}