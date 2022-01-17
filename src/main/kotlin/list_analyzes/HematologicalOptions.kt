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

private val listAnalyzes = listOf(
    Analysis("1.1", "Общий (клинический) анализ крови"),
    Analysis("1.2","Ретикулоциты","0,59-2,07%"),
    Analysis("1.3","Скорость оседания эритроцитов (СОЭ)","2 – 20 мм/ч")
)

private val analyzes_1_1 = listOf(
    Analysis("1.1.1","Гемоглобин", "117-155 г/л"),
    Analysis("1.1.2","Лейкоциты(WBC)", "4.00 - 10.00*10^9/л"),
    Analysis("1.1.3","Эритроциты(RBC)" , "3.80 - 5.10*10^12/л"),
    Analysis("1.1.4","Гематокрит(HCT)", "35.0 - 45.0%"),
    Analysis("1.1.5","Тромбоциты (PLT)", "150 - 400*10^9/л"),
    Analysis("1.1.6","Лимфоциты, % (LY%)","19.0 - 37.0%"),
    Analysis("1.1.7","Моноциты, % (MO%)","3.0 - 12.0%"),
    Analysis("1.1.8","Эозинофилы, % (EO%)","1.0 - 5.0%"),
    Analysis("1.1.9","МСН","26,5-33,5 pg"),
    Analysis("1.1.10","Палочкоядерные нейрофилы","1-6%"),
    Analysis("1.1.11","Сегментоядерные нейтрофилы","47-72%")
)



@Composable
fun HematologicalOptions(
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
                    if(analysis.referenceValue != null) addAnalysis(analysis)
                    else analyzes_1_1.forEach { addAnalysis(it) }
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