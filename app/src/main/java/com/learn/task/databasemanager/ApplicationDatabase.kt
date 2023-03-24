package com.learn.task.databasemanager
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CountryDbModel::class],
    version = 6,
    exportSchema = false
)

abstract  class ApplicationDatabase : RoomDatabase(){
    abstract fun favoriteDao(): CountryDao
    companion object {
        private var newInstance: ApplicationDatabase? = null

        fun getDatabase(context: Context): ApplicationDatabase {
            return if (newInstance == null) {
                newInstance = Room.databaseBuilder(context, ApplicationDatabase::class.java, "country_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                newInstance!!
            } else
                newInstance!!
        }
    }
}