package list_analyzes

import allData
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


@Composable
fun HematologicalOptions(
    addAnalysis: (analysis : Analysis)->Unit
){
    val listAnalyzes = allData.getListAnalyzes_1()
    val analyzes_1_1 = allData.getListAnalyzes_1_1()
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