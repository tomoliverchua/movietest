package com.goldendevs.testapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.goldendevs.testapplication.common.DATABASE_NAME
import com.goldendevs.testapplication.db.dao.MovieDao
import com.goldendevs.testapplication.model.MovieDetailsEntity


@Database(
    entities = [MovieDetailsEntity::class],
    version = 1,
    exportSchema = false
)
 abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        // For singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context)
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }

    }
}