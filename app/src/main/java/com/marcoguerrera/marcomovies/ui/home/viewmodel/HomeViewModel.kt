package com.marcoguerrera.marcomovies.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcoguerrera.marcomovies.MarcoMoviesApp
import com.marcoguerrera.marcomovies.data.source.local.model.PopularMovieEntity
import com.marcoguerrera.marcomovies.data.repository.MovieRepository
import com.marcoguerrera.marcomovies.data.source.local.mapper.PopularMoviesLocalMapper
import com.marcoguerrera.marcomovies.data.source.remote.mapper.PopularMoviesRemoteMapper
import com.marcoguerrera.marcomovies.model.PopularMovie
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//class HomeViewModel(application: MarcoMoviesApp) : AndroidViewModel(application) {
class HomeViewModel: ViewModel() {
    private val TAG = "HomeViewModel"
    private val homeRepository = MovieRepository()

    var listPopular = MutableLiveData<List<PopularMovie>>()

    //val popMovDao = getApplication<MarcoMoviesApp>().applicationContext.
    val popMovDao = MarcoMoviesApp.getDatabase()?.popularMoviesDao()

    init {
        getMoviesCategory()
    }

    /*fun getMoviesCategory() {
        viewModelScope.launch(IO) {
            val r = async { homeRepository.getPopular() }
            Log.d(TAG,"${r.await()}")
        }
    }*/

    fun getMoviesCategory() {
        viewModelScope.launch(IO) {
            val popMovItemRespList = homeRepository.getPopular()
            var popMovList: MutableList<PopularMovie> = mutableListOf<PopularMovie>()
            withContext(IO) {
                var popMovEntityList: MutableList<PopularMovieEntity> = mutableListOf<PopularMovieEntity>()
                if (popMovItemRespList != null) {
                    for (popMovItem in popMovItemRespList) {
                        val popMov = PopularMoviesRemoteMapper.mapFromRemote(popMovItem)
                        popMovList.add(popMov)
                        popMovEntityList.add(PopularMoviesLocalMapper.mapToLocal(popMov))
                    }
                }
                //* - spread operator, converte lista in vararg
                popMovDao?.insertAll(*popMovEntityList.toTypedArray())
            }
            withContext(Main) {
                listPopular.postValue(popMovList!!)
            }
        }
    }
}