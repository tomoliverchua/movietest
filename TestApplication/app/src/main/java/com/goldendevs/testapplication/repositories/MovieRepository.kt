package com.goldendevs.testapplication.repositories

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.goldendevs.testapplication.apiservices.APIClient
import com.goldendevs.testapplication.apiservices.ItunesServices
import com.goldendevs.testapplication.common.AppExecutors


import com.goldendevs.testapplication.db.dao.MovieDao
import com.goldendevs.testapplication.model.DataResponse
import com.goldendevs.testapplication.model.MovieDetailsEntity
import com.goldendevs.testapplication.model.Result
import com.goldendevs.testapplication.repoCallback.MovieRepoCallback
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(context: Context) :  KoinComponent {

    var apiServices: ItunesServices = APIClient.client!!.create(ItunesServices::class.java)
    private val movieDao: MovieDao by inject()
    private val executors: AppExecutors by inject()


    // get movies from api to room database

    fun getMovies(callback: MovieRepoCallback.OnMovieRepoCallback) {
        val getMovies = apiServices.getMovies()
        getMovies.enqueue(object : Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback.onSuccess(it)
                        it.results.forEach{result->
                            executors.diskIO().execute {
                                movieDao.save(result.toMovieDetails())
                            }
                        }
                    }
                    Log.d("API_CALL", response.body().toString())
                    return
                }
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Log.d("API_CALL", t.message)
                callback.onFail("Connection Error!")
                call.cancel()
            }
        })
    }

    // get all movie details
    fun getDbMovies(): LiveData<MutableList<MovieDetailsEntity>> = movieDao.getMovieList()


    // get movie by ref. Id
    fun getDbMovieById(movieId: Int): LiveData<MovieDetailsEntity> = movieDao.getMovieById(movieId)
}