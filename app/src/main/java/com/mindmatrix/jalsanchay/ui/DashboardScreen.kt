package com.mindmatrix.jalsanchay.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mindmatrix.jalsanchay.utils.CalculationUtils
import com.mindmatrix.jalsanchay.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    val total = viewModel.totalLiters.value
    val records = viewModel.records.value
    val tankCapacity = viewModel.tankCapacity.value

    val progress =
        if (tankCapacity > 0)
            (total / tankCapacity).toFloat().coerceIn(0f, 1f)
        else 0f

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Jal-Sanchay Tracker")
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("entry")
                }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {

                ElevatedCard(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "Tank Storage",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        LinearProgressIndicator(
                            progress = { progress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(14.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            "${total.toInt()} / ${tankCapacity.toInt()} L Stored"
                        )
                    }
                }
            }

            item {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    ElevatedCard(
                        modifier = Modifier.weight(1f)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text("Today's Save")

                            Text(
                                CalculationUtils.formatLiters(
                                    records.firstOrNull()?.litersSaved ?: 0.0
                                ),
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    ElevatedCard(
                        modifier = Modifier.weight(1f)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text("Total Saved")

                            Text(
                                CalculationUtils.formatLiters(total),
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            item {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Button(
                        onClick = {
                            navController.navigate("setup")
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Setup")
                    }

                    Button(
                        onClick = {
                            navController.navigate("report")
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Reports")
                    }

                    OutlinedButton(
                        onClick = {
                            navController.navigate("tips")
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Tips")
                    }
                }
            }

            item {

                Text(
                    "Recent Entries",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            items(records.take(5)) { record ->

                ElevatedCard(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),

                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {

                            val format = SimpleDateFormat(
                                "dd MMM yyyy",
                                Locale.getDefault()
                            )

                            Text(
                                format.format(record.date),
                                fontWeight = FontWeight.SemiBold
                            )

                            Text("${record.rainfallMm} mm rainfall")
                        }

                        Text(
                            CalculationUtils.formatLiters(
                                record.litersSaved
                            ),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}