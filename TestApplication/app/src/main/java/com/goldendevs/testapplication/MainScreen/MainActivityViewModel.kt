package com.goldendevs.testapplication.MainScreen

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goldendevs.testapplication.model.DataResponse
import com.goldendevs.testapplication.model.MovieDetailsEntity
import com.goldendevs.testapplication.repoCallback.MovieRepoCallback
import com.goldendevs.testapplication.repositories.MovieRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainActivityViewModel : ViewModel(), KoinComponent {

    private val movieRepo : MovieRepository by inject()

    private var dataResponse = MutableLiveData<DataResponse>()
    fun getDataResponse(): LiveData<DataResponse> = dataResponse

    fun getMovies() {
        movieRepo.getMovies(object : MovieRepoCallback.OnMovieRepoCallback {
            override fun onSuccess(dr: DataResponse) {
                dataResponse.value = dr
            }
            override fun onFail(errMessage: String) {
                // Error
            }

        })
    }

    fun getDbMovies() : LiveData<MutableList<MovieDetailsEntity>> = movieRepo.getDbMovies()
    fun getDbMovieById(movieId: Int) : LiveData<MovieDetailsEntity> = movieRepo.getDbMovieById(movieId)


}