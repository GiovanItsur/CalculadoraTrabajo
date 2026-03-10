package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import viewmodel.TipCalculatorViewModel

@Composable
fun TipCalculatorScreen(
    viewModel: TipCalculatorViewModel = viewModel { TipCalculatorViewModel() }
) {
    val uiState by viewModel.uiState.collectAsState()

    DisposableEffect(Unit) {
        println("Compose: Entrando a la composición de TipCalculatorScreen")
        onDispose {
            println("Compose: Saliendo de la composición de TipCalculatorScreen (Dispose)")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Calculate Tip", style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.billAmount,
            onValueChange = { viewModel.onBillAmountChange(it) },
            label = { Text("Monto de la cuenta") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.tipPercentage,
            onValueChange = { viewModel.onTipPercentageChange(it) },
            label = { Text("Porcentaje de propina (%)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Redondear hacia arriba")
            Switch(
                checked = uiState.roundUp,
                onCheckedChange = { viewModel.onRoundUpChange(it) }
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Propina: ${uiState.tipResult}",
            style = MaterialTheme.typography.bodySmall
        )
    }
}