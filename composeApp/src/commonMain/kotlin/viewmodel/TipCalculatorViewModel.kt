package viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.ceil
data class TipUiState(
    val billAmount: String = "",
    val tipPercentage: String = "15",
    val roundUp: Boolean = false,
    val tipResult: String = "$0.00"
)

class TipCalculatorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TipUiState())
    val uiState: StateFlow<TipUiState> = _uiState.asStateFlow()

    fun onBillAmountChange(amount: String) {
        _uiState.update { it.copy(billAmount = amount) }
        calculateTip()
    }

    fun onTipPercentageChange(percentage: String) {
        _uiState.update { it.copy(tipPercentage = percentage) }
        calculateTip()
    }

    fun onRoundUpChange(roundUp: Boolean) {
        _uiState.update { it.copy(roundUp = roundUp) }
        calculateTip()
    }

    private fun calculateTip() {
        val amount = _uiState.value.billAmount.toDoubleOrNull() ?: 0.0
        val percentage = _uiState.value.tipPercentage.toDoubleOrNull() ?: 0.0

        var tip = (percentage / 100) * amount
        if (_uiState.value.roundUp) {
            tip = ceil(tip)
        }

        val formattedTip = "$${((tip * 100).toInt()) / 100.0}"

        _uiState.update { it.copy(tipResult = formattedTip) }
    }

    override fun onCleared() {
        super.onCleared()
        println("ViewModel: onCleared() invocado. Liberando recursos y destruyendo ViewModel...")
    }
}