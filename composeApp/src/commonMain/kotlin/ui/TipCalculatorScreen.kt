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
){
    val uiState by viewModel.uiState.collectAsState()

    DisposableEffect(Unit) {
        println("Entrando")
        onDispose {
            println("Saliendo")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "CALCULAR PROPINA", style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.billAmount,
            onValueChange = { viewModel.billAmountUpdate(it) },
            label = { Text("Total Monto Recibo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.tipPercentage,
            onValueChange = { viewModel.tipPercentageUpdate(it) },
            label = { Text("Porcentaje Propina") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Redondear Arriba!")
            Switch(
                checked = uiState.roundTip,
                onCheckedChange = { viewModel.roundTipUpdate(it) }
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Propina: ${uiState.tipResult}",
            style = MaterialTheme.typography.bodySmall
        )
    }
}
