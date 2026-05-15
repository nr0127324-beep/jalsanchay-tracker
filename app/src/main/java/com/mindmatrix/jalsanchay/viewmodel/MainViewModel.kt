package com.mindmatrix.jalsanchay.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindmatrix.jalsanchay.data.RainData
import com.mindmatrix.jalsanchay.data.RainRepository
import com.mindmatrix.jalsanchay.utils.CalculationUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RainRepository
) : ViewModel() {

    var roofArea = mutableStateOf(100.0)
    var tankCapacity = mutableStateOf(1000.0)
    var totalLiters = mutableStateOf(0.0)
    var todayLiters = mutableStateOf(0.0)
    var records = mutableStateOf<List<RainData>>(emptyList())

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            repository.getAllRecords().collectLatest {
                records.value = it
            }
        }
        viewModelScope.launch {
            repository.getTotalLiters().collectLatest {
                totalLiters.value = it ?: 0.0
            }
        }
    }

    fun saveRainfall(rainfallMm: Double) {
        val liters = CalculationUtils.calculateHarvestedWater(
            roofAreaSqM = roofArea.value,
            rainfallMm = rainfallMm
        )

        val waterDays = CalculationUtils.calculateWaterDays(liters)

        val data = RainData(
            date = Date(),
            rainfallMm = rainfallMm,
            roofArea = roofArea.value,
            litersSaved = liters,
            waterDays = waterDays
        )

        viewModelScope.launch {
            repository.insertRecord(data)
        }
    }
    private fun calculateLiters(rainfallMm: Double): Double {
        val runoffCoefficient = 0.85
        return roofArea.value * rainfallMm * 0.0929 * runoffCoefficient
    }

    fun getMonthlyTotal(): Double {
        return records.value.sumOf { it.litersSaved }
    }
}