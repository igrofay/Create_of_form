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


private val  analyzes_7 = listOf(
    Analysis("7.1","Исследование соскобов с шейки матки и цервикального канала"),
    Analysis("7.2","Цитологическое исследование пунктата молочной  железы"),
    Analysis("7.3","Цитологическое исследование пунктата щитовидной железы")
)

@Composable
fun CytologicalStudies(addAnalysis: (analysis : Analysis)->Unit){
    val stateVertical = rememberScrollState(0)

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Column(
            modifier = Modifier.verticalScroll(stateVertical)
        ){
            analyzes_7.forEach { analysis ->
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