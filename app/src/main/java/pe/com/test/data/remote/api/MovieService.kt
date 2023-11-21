package pe.com.test.data.remote.api

import pe.com.test.data.entities.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("3/movie/popular")
    suspend fun popularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: String,
        @Query("language") language: String
    ): Response<BaseResponse>

    @GET("3/movie/upcoming")
    suspend fun upcomingMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: String,
        @Query("language") language: String
    ): Response<BaseResponse>
}
