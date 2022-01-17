package list_analyzes

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.entities.Analysis

private val  listAnalyzes = listOf(
    Analysis("3.1","Исследование уровня фибриногена в крови","1.80 - 3.50 г/л"),
    Analysis("3.2","Определение протромбинового (тромбопластинового) времени в крови или плазме (ПТВ)","11.00 - 16.00 сек"),
    Analysis("3.3","Определение Активированного частичного тромбопластинового времени (АЧТВ)","21.1 - 36.5 сек"),
    Analysis("3.4","Определение концентрации D-димера в крови","0.00 - 0.55 мкгFEU/мл")
)

@Composable
fun CoagulationOptions(
    addAnalysis: (analysis : Analysis)->Unit
){
    val stateVertical = rememberScrollState(0)
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Column(
            modifier = Modifier.verticalScroll(stateVertical)
        ){
            listAnalyzes.forEach { analysis ->
                ItemAnalysis(
                    analysis
                ) {
                    addAnalysis(analysis)
                }
                Spacer(Modifier.height(12.dp))
            }
        }
        VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd)
                .fillMaxHeight(),
            adapter = rememberScrollbarAdapter(stateVertical)
        )
    }
}