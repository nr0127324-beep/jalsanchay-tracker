package com.mindmatrix.jalsanchay.data

import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

class RainRepository @Inject constructor(private val dao: RainDao) {
    suspend fun insertRecord(data: RainData) = dao.insert(data)
    fun getAllRecords() = dao.getAllRecords()
    fun getTotalLiters() = dao.getTotalLiters()
    fun getMonthlyRecords(start: Date, end: Date) = dao.getMonthlyRecords(start, end)
}