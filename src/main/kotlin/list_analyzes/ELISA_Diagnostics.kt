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

private val  listAnalyzes = listOf(
    Analysis("4.1.1","ТТГ","0.270 - 4.200 мкМЕ/мл"),
    Analysis("4.1.2","Т3 общий","1.20 - 3.10 нмоль/л"),
    Analysis("4.1.3","Т3 свободный","3.10 - 6.80 пмоль/л"),
    Analysis("4.1.4","Т4 общий","66.00 - 181.00 нмоль/л"),
    Analysis("4.1.5","Т4 свободный","10.80 - 22.00 пмоль/л"),
    Analysis("4.1.6","Определение содержания антител к тиреопероксидазе в крови (анти-ТПО)","0.00 - 34.00 МЕ/мл"),
    Analysis("4.2.1","Исследование уровня простатспецифическогоантигена общего в крови (ПСА)","0.000 - 4.000 нг/мл"),
    Analysis("4.3.1","Определение концентрации N-терминального фрагмента" +
            " предшественника мозгового натрийуретического пептида  в сыворотке крови.","<125.00 пг/мл"),
    Analysis("4.4.1","Гепатит C, anti-HCV сумм. (кач)","отрицательно"),
    Analysis("4.4.2","Гепатит В, HBs Ag (кач)","отрицательно"),
    Analysis("4.5.1","Сифилис сум. АТ (IgG и IgM) (кач)","отрицательно"),
    Analysis("4.5.2","Сифилис RPR (п/кол)","отрицательно")
)
@Composable
fun ELISA_Diagnostics(
    addAnalysis: (analysis : Analysis)->Unit
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