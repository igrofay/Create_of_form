package list_analyzes

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import data.entities.Analysis
import data.entities.Analysis_5_6
import data.state.Studies

@Composable
fun ViewListAnalyzes(
    listAnalyzes: MutableList<Analysis>,
    listAnalyzes_5_6: MutableList<Analysis_5_6>
){
    val stateHorizontal = rememberScrollState(0)
    var selectItem by remember {
        mutableStateOf(Studies.Hematological)
    }
    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RowElementHeaders(
            selectItem = selectItem,
            changeItem = {selectItem = it},
            horizontalScroll = stateHorizontal
        )
        HorizontalScrollbar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            adapter = rememberScrollbarAdapter(stateHorizontal)
        )

        AnimatedVisibility(
            visible = selectItem == Studies.Hematological,
        ){
            HematologicalOptions{
                listAnalyzes.add(it)
            }
        }
        AnimatedVisibility(
            visible = selectItem == Studies.Biochemical,
        ){
            BiochemicalOptions{
                listAnalyzes.add(it)
            }
        }
        AnimatedVisibility(
            visible = selectItem == Studies.Coagulation,
        ){
            CoagulationOptions{
                listAnalyzes.add(it)
            }
        }
        AnimatedVisibility(
            visible = selectItem == Studies.ELISA_diagnostics,
        ){
            ELISA_Diagnostics {
                listAnalyzes.add(it)
            }
        }
        AnimatedVisibility(
            visible = selectItem == Studies.Chemical_microscopic,
        ){
            ChemicalMicroscopicOptions(
                addAnalysis =  {
                    listAnalyzes.add(it)
                },
                addAnalysis_5_6 = {
                    listAnalyzes_5_6.add(it)
                }
            )
        }
        AnimatedVisibility(
            visible = selectItem == Studies.MicroscopicExaminationUrogenitalTract,
        ){
            MicroscopicExaminationUrogenitalTract{
                listAnalyzes.add(it)
            }
        }
        AnimatedVisibility(
            visible = selectItem == Studies.CytologicalStudies,
        ){
            CytologicalStudies{
                listAnalyzes.add(it)
            }
        }
    }
}

@Composable
fun RowElementHeaders(
    selectItem: Studies,
    changeItem: (studies: Studies)-> Unit,
    listStudies: Array<Studies> = Studies.values(),
    horizontalScroll: ScrollState
){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .horizontalScroll(horizontalScroll),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        listStudies.forEach { studies ->
            ItemHeaders(
                select = selectItem == studies,
                clickItem = { changeItem(studies) },
                title = studies.nameRu
            )
        }
    }
}

@Composable
fun ItemHeaders(
    select: Boolean,
    clickItem: ()-> Unit,
    title: String
){
    val color by animateColorAsState(
        if (select) colors.primary else Color.Gray
    )
    TextButton(
        onClick = clickItem,
        Modifier.width(IntrinsicSize.Min)
    ){
        Column {
            Text(
                text = title,
                style = typography.subtitle1,
                color = color,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(8 .dp))
            Divider(
                color = color,
                thickness = 2.dp
            )
        }
    }
}
