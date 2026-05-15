package com.mindmatrix.jalsanchay.di

import android.content.Context
import com.mindmatrix.jalsanchay.data.RainDao
import com.mindmatrix.jalsanchay.data.RainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RainDatabase {
        return RainDatabase.getDatabase(context)
    }

    @Provides
    fun provideRainDao(database: RainDatabase): RainDao {
        return database.rainDao()
    }
}
