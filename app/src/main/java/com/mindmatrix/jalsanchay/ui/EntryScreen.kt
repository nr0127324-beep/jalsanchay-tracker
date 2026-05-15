package com.mindmatrix.jalsanchay.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mindmatrix.jalsanchay.viewmodel.MainViewModel

@Composable
fun EntryScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    var rainfall by remember {
        mutableStateOf("")
    }

    var error by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            "Add Rainfall Entry",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            "Track daily rainwater harvesting easily."
        )

        OutlinedTextField(
            value = rainfall,

            onValueChange = {
                rainfall = it
                error = ""
            },

            label = {
                Text("Rainfall (mm)")
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),

            modifier = Modifier.fillMaxWidth(),

            singleLine = true
        )

        if (error.isNotEmpty()) {

            Text(
                error,
                color = MaterialTheme.colorScheme.error
            )
        }

        Button(
            onClick = {

                val mm = rainfall.toDoubleOrNull()

                when {

                    mm == null -> {
                        error = "Enter valid rainfall value"
                    }

                    mm <= 0 -> {
                        error = "Rainfall should be greater than 0"
                    }

                    else -> {
                        viewModel.saveRainfall(mm)
                        navController.popBackStack()
                    }
                }
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Save Entry")
        }
    }
}