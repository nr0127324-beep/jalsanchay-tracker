package com.mindmatrix.jalsanchay.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mindmatrix.jalsanchay.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(navController: NavController, viewModel: MainViewModel) {
    val records = viewModel.records.value
    val monthlyTotal = viewModel.getMonthlyTotal()

    Scaffold(topBar = { TopAppBar(title = { Text("Monthly Report") }) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("This Month's Savings", style = MaterialTheme.typography.titleLarge)
                    Text("${monthlyTotal.toInt()} Liters", style = MaterialTheme.typography.headlineMedium)
                }
            }

            Spacer(Modifier.height(16.dp))

            Text("History", style = MaterialTheme.typography.titleLarge)

            LazyColumn {
                items(records) { record ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
                                Text(dateFormat.format(record.date))
                                Text("${record.rainfallMm} mm rain", style = MaterialTheme.typography.bodyMedium)
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Text("${record.litersSaved.toInt()} L", fontWeight = FontWeight.Bold)
                                Text("${record.waterDays.toInt()} days", style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }
            }
        }
    }
}