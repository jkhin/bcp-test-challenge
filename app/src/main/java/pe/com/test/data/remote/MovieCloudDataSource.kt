package pe.com.test.data.remote

import pe.com.test.data.entities.BaseResponse

interface MovieCloudDataSource {
    suspend fun getPopularMovies(): BaseResponse
    suspend fun getUpcomingMovies(): BaseResponse

}