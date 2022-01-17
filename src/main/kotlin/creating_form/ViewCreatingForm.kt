package creating_form

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import data.entities.Patient

@Composable
@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
fun ViewCreatingForm(
    patient: Patient,
    openDialogAddAnalysis: ()-> Unit,
    resetPatient: ()-> Unit
){
    val stateHorizontal = rememberScrollState(0)
    val stateVertical = rememberScrollState(0)
    Box{
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(stateVertical)
                .horizontalScroll(stateHorizontal),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var size by remember { mutableStateOf(Size.Zero) }
            StandardData(patient){ coordinates ->
                size = coordinates.size.toSize()
            }
            patient.listAnalyzes.forEach { analysis ->
                ItemAnalysisInput(
                    analysis,
                    size.width
                )
            }
            patient.listAnalyzes_5_6.forEach {
                ItemAnalysis_5_6_Input(
                    it,size.width
                )
            }
            Comment(
                patient.comment,
                size.width
            )
        }
        VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd)
                .fillMaxHeight(),
            adapter = rememberScrollbarAdapter(stateVertical)
        )
        HorizontalScrollbar(
            modifier = Modifier.align(Alignment.BottomStart)
                .fillMaxWidth(),
            adapter = rememberScrollbarAdapter(stateHorizontal)
        )
        Column(
            Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 24.dp , end = 24.dp)
        ) {
            TooltipArea(
                tooltip = {
                    // composable tooltip content
                    Surface(
                        modifier = Modifier.shadow(4.dp),
                        color = Color(255, 255, 210),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "Очистить форму",
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                },
                delayMillis = 600
            ){
                FloatingActionButton(
                    onClick = resetPatient
                ){
                    Icon(Icons.Default.Delete , null)
                }
            }
            Spacer(Modifier.height(24.dp))
            TooltipArea(
                tooltip = {
                    // composable tooltip content
                    Surface(
                        modifier = Modifier.shadow(4.dp),
                        color = Color(255, 255, 210),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "Добавить анализ",
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                },
                delayMillis = 600
            ){
                FloatingActionButton(
                    onClick = openDialogAddAnalysis
                ){
                    Icon(Icons.Default.Add , null)
                }
            }
            Spacer(Modifier.height(24.dp))
            TooltipArea(
                tooltip = {
                    // composable tooltip content
                    Surface(
                        modifier = Modifier.shadow(4.dp),
                        color = Color(255, 255, 210),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "Создать документ",
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                },
                delayMillis = 600
            ){
                FloatingActionButton(
                    onClick = {}
                ){
                    Icon(Icons.Default.Edit , null)
                }
            }
        }
    }
}
