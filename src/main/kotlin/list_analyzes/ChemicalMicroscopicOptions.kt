package list_analyzes

import allData
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
    val listAnalyzes = allData.getListAnalyzes_5()
    val analyzes_5_1 = allData.getListAnalyzes_5_1()
    val analysis_5_3 = allData.getListAnalyzes_5_3()
    val analysis_5_5 = allData.getListAnalyzes_5_5()
    val analysis_5_6 = allData.getListAnalyzes_5_6()
    val analysis_5_7 = allData.getListAnalyzes_5_7()

    fun checkItem(
        analysis: Analysis ,
        add: (Analysis) ->Unit
    )= when (analysis.id){
        "5.1"-> analyzes_5_1.forEach { add(it) }
        "5.3"-> analysis_5_3.forEach { add(it) }
        "5.5" -> analysis_5_5.forEach { add(it) }
        "5.7" -> analysis_5_7.forEach { add(it) }
        else -> add(analysis)
    }

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
