package com.mindmatrix.jalsanchay.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface RainDao {
    @Insert
    suspend fun insert(data: RainData)

    @Query("SELECT * FROM rain_data ORDER BY date DESC")
    fun getAllRecords(): Flow<List<RainData>>

    @Query("SELECT SUM(litersSaved) FROM rain_data")
    fun getTotalLiters(): Flow<Double?>

    @Query("SELECT * FROM rain_data WHERE date BETWEEN :start AND :end")
    fun getMonthlyRecords(start: Date, end: Date): Flow<List<RainData>>
}