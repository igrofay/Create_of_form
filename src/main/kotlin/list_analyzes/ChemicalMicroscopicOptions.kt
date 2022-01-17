package list_analyzes

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.entities.Analysis
import data.entities.Analysis_5_6

@Composable
fun ChemicalMicroscopicOptions(
    addAnalysis: (Analysis)->Unit,
    addAnalysis_5_6: (Analysis_5_6) -> Unit
){
    var search by remember {
        mutableStateOf("")
    }

    val searchList = remember {
        mutableStateListOf<Analysis>()
    }
    if (search.isEmpty()){
        searchList.clear()
        searchList.addAll(listAnalyzes)
    } else {
        searchList.clear()
        listAnalyzes.forEach { analysis ->
            if (analysis.name.lowercase().contains(search.lowercase())
                || analysis.id.contains(search)
            ){
                searchList.add(analysis)
            }
        }
    }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        val stateVertical = rememberScrollState(0)
        Column(
            Modifier.verticalScroll(stateVertical),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = search,
                singleLine = true,
                leadingIcon = {
                    Icon(Icons.Default.Search , null)
                },
                onValueChange = { search = it },
                textStyle = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            searchList.forEach { analysis ->
                ItemAnalysis(
                    analysis
                ) {
                    if (analysis.id=="5.6") analysis_5_6.forEach { addAnalysis_5_6(it) }
                    else checkItem(analysis, addAnalysis)

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

private fun checkItem(
    analysis: Analysis ,
    add: (Analysis) ->Unit
)= when (analysis.id){
    "5.1"-> analyzes_5_1.forEach { add(it) }
    "5.3"-> analysis_5_3.forEach { add(it) }
    "5.5" -> analysis_5_5.forEach { add(it) }
    "5.7" -> analysis_5_7.forEach { add(it) }
    else -> add(analysis)
}

private val listAnalyzes = listOf(
    Analysis("5.1","Общий (клинический) анализ мочи"),
    Analysis("5.2.1","Белок Бенс-Джонса","не обнаружено"),
    Analysis("5.3","Микроскопическое исследование кала на яйца и личинки гельминтов"),
    Analysis("5.4.1","Реакция на скрытую кровь","отрицательно"),
    Analysis("5.5","Общий анализ мокроты"),
    Analysis("5.6","Анализ мочи по Зимницкому"),
    Analysis("5.7","Анализ мочи по Нечипоренко")
)


private val analyzes_5_1 = listOf(
    Analysis("5.1.1","Цвет","от соломенно-желтого до желтого"),
    Analysis("5.1.2","Прозрачность","прозрачная"),
    Analysis("5.1.3","Удельный вес","1.003 - 1.030"),
    Analysis("5.1.4","Реакция","5.0 - 7.5"),
    Analysis("5.1.5","Белок","не обнаружено или менее 0,1 г/л"),
    Analysis("5.1.6","Билирубин","не обнаружено"),
    Analysis("5.1.7", "Билирубин", "не обнаружено"),
    Analysis("5.1.8", "Уробилиноген", "не обнаружено или следы"),
    Analysis("5.1.9", "Кетоновые тела", "не обнаружено"),
    Analysis("5.1.10", "Нитриты", "не обнаружено"),
    Analysis("5.1.11", "Реакция на кровь (гемоглобин)", "не обнаружено"),
    Analysis("5.1.12", "Лейкоцитарная эстераза", "Не обнаружено или следы"),
    Analysis("5.1.13", "Микроскопия мочи"),
    Analysis("5.1.14", "Эпителий: плоский", "0.0 - 15.0 клет/мкл"),
    Analysis("5.1.15", "Лейкоциты", "0.0 - 27.5 клет/мкл"),
    Analysis("5.1.16", "Эритроциты", "0.0 - 11.0 клет/мкл"),
    Analysis("5.1.17", "Цилиндры", "не обнаружено"),
    Analysis("5.1.18", "Кристаллы", "не обнаружено"),
    Analysis("5.1.19", "Бактерии", "не обнаружено или небольшое количество"),
    Analysis("5.1.20", "Слизь", "небольшое количество")
)


private val analysis_5_3 = listOf(
    Analysis("5.3.1", "Diphyllobothriumlatum", "не обнаружены"),
    Analysis("5.3.2", "Ascarislumbricoides", "не обнаружены"),
    Analysis("5.3.3", "Trichocephalustrichiurus", "не обнаружены"),
    Analysis("5.3.4", "Thominxaerophilus", "не обнаружены"),
    Analysis("5.3.5", "Ancylostomatidaegenussp", "не обнаружены"),
    Analysis("5.3.6", "Fasciolahepatica", "не обнаружены"),
    Analysis("5.3.7", "Opisthorchisfelineus", "не обнаружены"),
    Analysis("5.3.8", "Trichostrongylidaesp", "не обнаружены"),
    Analysis("5.3.9", "Dicrocoeliumlanceatum", "не обнаружены"),
    Analysis("5.3.10", "Schistosomamanson", "не обнаружены"),
    Analysis("5.3.11", "Schistosomajaponicum", "не обнаружены")
)

private val analysis_5_5 = listOf(
    Analysis("5.5.1", "Количество"),
    Analysis("5.5.2", "Цвет"),
    Analysis("5.5.3", "Запах"),
    Analysis("5.5.4", "Характер"),
    Analysis("5.5.5", "Консистенция"),
    Analysis("5.5.6", "Примеси"),
    Analysis("5.5.7", "Эпителий (п/зр)"),
    Analysis("5.5.8", "Альвеолярные макрофаги (п/зр)"),
    Analysis("5.5.9", "Лейкоциты (п/зр)"),
    Analysis("5.5.10", "Эритроциты (п/зр)"),
    Analysis("5.5.11", "Эозинофилы (п/зр)"),
    Analysis("5.5.12", "Волокна эластические"),
    Analysis("5.5.13", "Прочая флора"),
    Analysis("5.5.14", "Спирали Куршмана"),
    Analysis("5.5.15", "Кристаллы Шарко-Лейдена"),
    Analysis("5.5.16", "Клетки с признаками атипии")
)

private val analysis_5_6 = listOf(
    Analysis_5_6("5.6.1","1"),
    Analysis_5_6("5.6.2","2"),
    Analysis_5_6("5.6.3","3"),
    Analysis_5_6("5.6.4","4"),
    Analysis_5_6("5.6.5","5"),
    Analysis_5_6("5.6.6","6"),
    Analysis_5_6("5.6.7","7"),
    Analysis_5_6("5.6.8","8"),
    Analysis_5_6("5.6.9","Дневной диурез"),
    Analysis_5_6("5.6.10","Ночной диурез"),
    Analysis_5_6("5.6.11","Общий диурез")
)

private val analysis_5_7 = listOf(
    Analysis("5.7.1","Лейкоциты","0,00-2,00"),
    Analysis("5.7.2","Эритроциты","0,00-1,00"),
    Analysis("5.7.3","Цилиндры","0-0,02")
)