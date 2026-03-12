package viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.ceil

data class calculatorUiState(
    val billAmount: String = "",
    val tipPercentage: String = "",
    val roundTip: Boolean = false,
    val tipResult: String = "$0.00"
)

class TipCalculatorViewModel : ViewModel() {
    private val uiStateMutable = MutableStateFlow(calculatorUiState())
    val uiState = uiStateMutable.asStateFlow()

    fun billAmountUpdate(recibo: String) {
        uiStateMutable.update {
            it.copy(billAmount = recibo)
        }
        calculateTip()
    }

    fun tipPercentageUpdate(porcentaje: String) {
        uiStateMutable.update {
            it.copy(tipPercentage = porcentaje)
        }
        calculateTip()
    }

    fun roundTipUpdate(redondear: Boolean) {
        uiStateMutable.update {
            it.copy(roundTip = redondear)
        }
        calculateTip()
    }

    private fun calculateTip(){
        val recibo = uiStateMutable.value.billAmount.toDoubleOrNull() ?: 0.0
        val porcentaje = uiStateMutable.value.tipPercentage.toDoubleOrNull() ?: 0.0
        var tipBefore = porcentaje / 100 * recibo

        if(uiStateMutable.value.roundTip){
            tipBefore = ceil(tipBefore)
        }

        val resTip = "$${((tipBefore * 100).toInt() / 100.0)}"

        uiStateMutable.update { it.copy(tipResult = resTip ) }
    }

    override fun onCleared() {
        super.onCleared()
        println("Muerto!")
    }
}
