package com.goldendevs.testapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.goldendevs.testapplication.model.MovieDetailsEntity


@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_details")
    fun getMovieList(): LiveData<MutableList<MovieDetailsEntity>>

    @Query("SELECT * FROM movie_details where id = :movieId ")
    fun getMovieById(movieId : Int): LiveData<MovieDetailsEntity>

    @Insert
    fun save(movieDetails: MovieDetailsEntity)

    @Update
    fun update(movieDetails: MovieDetailsEntity)

    @Query("DELETE FROM movie_details")
    fun clearAll()
}