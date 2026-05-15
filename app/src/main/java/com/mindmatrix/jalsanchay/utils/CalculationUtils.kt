package com.mindmatrix.jalsanchay.utils

object CalculationUtils {

    /**
     * 1mm rainfall on 1 sq.m roof = 1 liter water
     */
    fun calculateHarvestedWater(
        roofAreaSqM: Double,
        rainfallMm: Double,
        runoffCoefficient: Double = 0.85
    ): Double {

        if (roofAreaSqM <= 0 || rainfallMm <= 0) {
            return 0.0
        }

        return roofAreaSqM * rainfallMm * runoffCoefficient
    }

    fun calculateWaterDays(litersSaved: Double): Double {
        if (litersSaved <= 0) return 0.0
        return litersSaved / 135.0
    }

    fun formatLiters(liters: Double): String {
        return if (liters >= 1000) {
            String.format("%.1fK L", liters / 1000)
        } else {
            "${liters.toInt()} L"
        }
    }

    fun isValidInput(roofArea: Double, rainfall: Double): Boolean {
        return roofArea > 0 && rainfall in 0.0..500.0
    }
}