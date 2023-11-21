package pe.com.test.di

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pe.com.test.BuildConfig
import pe.com.test.data.mappers.MovieMapper
import pe.com.test.data.remote.MovieCloudDataSource
import pe.com.test.data.remote.MovieCloudDataSourceImpl
import pe.com.test.data.remote.api.MovieService
import pe.com.test.data.repositories.MovieRepositoryImpl
import pe.com.test.domain.GetPopularMoviesUseCase
import pe.com.test.domain.GetUpcomingMoviesUseCase
import pe.com.test.domain.repositories.MovieRepository
import pe.com.test.domain.use_cases.GetPopularMoviesUseCaseImpl
import pe.com.test.domain.use_cases.GetUpcomingMoviesUseCaseImpl
import pe.com.test.ui.mappers.MovieModelMapper
import pe.com.test.ui.view_models.MovieViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    // Networking
    factory { providesGson() }
    factory { providesOkHttpClient() }
    factory { providesPokemonService(get()) }
    single { providesRetrofit(get(), get()) }

    // data
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<MovieCloudDataSource> { MovieCloudDataSourceImpl(get()) }
    single { MovieMapper() }

    // domain
    single<GetUpcomingMoviesUseCase> { GetUpcomingMoviesUseCaseImpl(get()) }
    single<GetPopularMoviesUseCase> { GetPopularMoviesUseCaseImpl(get()) }

    // ui
    // view-model
    viewModel { MovieViewModel(get(), get(), get()) }
    single { MovieModelMapper() }

}

fun providesRetrofit(
    gson: Gson,
    okHttpClient: OkHttpClient
) : Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

fun providesGson(): Gson = Gson()

fun providesOkHttpClient() : OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    )
    .connectTimeout(10, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.SECONDS)
    .writeTimeout(10, TimeUnit.SECONDS)
    .build()

fun providesPokemonService(retrofit: Retrofit) = retrofit.create(MovieService::class.java)
