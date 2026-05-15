package com.mindmatrix.jalsanchay.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "rain_data")
data class RainData(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: Date,
    val rainfallMm: Double,
    val roofArea: Double,
    val litersSaved: Double,
    val waterDays: Double
)