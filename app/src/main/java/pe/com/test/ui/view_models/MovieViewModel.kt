package pe.com.test.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.com.test.domain.GetPopularMoviesUseCase
import pe.com.test.domain.GetUpcomingMoviesUseCase
import pe.com.test.ui.mappers.MovieModelMapper
import pe.com.test.ui.models.MovieModel

class MovieViewModel
constructor(
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val movieModelMapper: MovieModelMapper
) : ViewModel() {


    private val _popularMovies: MutableLiveData<List<MovieModel>> = MutableLiveData<List<MovieModel>>()
    val popularMovies: LiveData<List<MovieModel>> get() = _popularMovies


    private val _upcomingMovies: MutableLiveData<List<MovieModel>> = MutableLiveData<List<MovieModel>>()
    val upcomingMovies: LiveData<List<MovieModel>> get() = _upcomingMovies

    val error = MutableLiveData<String>()


    fun fetchData() = with(viewModelScope) {
        launch(_errorHandler + Dispatchers.IO) {
            val popularMovies = getPopularMoviesUseCase.get().map { movieModelMapper.map(it) }
            val upcomingMovies = getUpcomingMoviesUseCase.get().map { movieModelMapper.map(it) }

            _popularMovies.postValue(popularMovies)
            _upcomingMovies.postValue(upcomingMovies)
        }
    }

    private val _errorHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            error.value = throwable.message
        }

}