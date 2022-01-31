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

//При этом для этих данных нужна отдельная таблица
private val analyzes_6 = listOf(
    Analysis("6.1"," Микроскопическое исследование отделяемого мочеполовых органов (уретра)"),
    Analysis("6.2","Микроскопическое исследование отделяемого мочеполовых органов (влагалище)"),
    Analysis("6.3","Микроскопическое исследование отделяемого мочеполовых органов (цервикальный канал)"),
    Analysis("6.4","Микроскопическое исследование отделяемого предстательной железы")
)

val analyzes_6_1= listOf(
    Analysis("6.1.1","Клетки эпителия (ур.)","5-10 в п/зр"),
    //Тут надо ввести тож значения
    Analysis("6.1.9","Дрожжи, грибы","отсутствуют")
)

val analysis_6_2 = listOf(
    Analysis("6.2.1","Клетки эпителия (вл.)","5-10 в п/зр")
    //Тут надо ввести тож значения
)

val analysis_6_3 = listOf<Analysis>()//Тут надо ввести тож значения
val analysis_6_4 = listOf<Analysis>()//Тут надо ввести тож значения

fun check(id: String, addAnalysis: (Analysis) -> Unit){
    when(id){
        "6.1"-> analyzes_6_1.forEach { addAnalysis(it) }
        "6.2"-> analysis_6_2.forEach { addAnalysis(it) }
        "6.3"-> analysis_6_3.forEach { addAnalysis(it) }
        "6.4"-> analysis_6_4.forEach { addAnalysis(it) }
    }
}
@Composable
fun MicroscopicExaminationUrogenitalTract(
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
            analyzes_6.forEach { analysis ->
                ItemAnalysis(
                    analysis
                ) {
                    check(analysis.id, addAnalysis)
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