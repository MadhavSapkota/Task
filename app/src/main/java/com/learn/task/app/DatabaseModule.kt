package com.learn.task.app
import android.content.Context
import androidx.room.Room
import com.learn.task.databasemanager.ApplicationDatabase


import dagger.Module
import dagger.Provides

@Module
open class DatabaseModule {
    @AppScope
    @Provides
    fun provideDatabase(context: Context): ApplicationDatabase {
        return Room.databaseBuilder(context, ApplicationDatabase::class.java, "grammar_db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}