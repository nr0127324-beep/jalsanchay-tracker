package com.mindmatrix.jalsanchay.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [RainData::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RainDatabase : RoomDatabase() {
    abstract fun rainDao(): RainDao

    companion object {
        @Volatile
        private var INSTANCE: RainDatabase? = null

        fun getDatabase(context: Context): RainDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RainDatabase::class.java,
                    "rain_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}