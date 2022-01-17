package creating_form

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import data.entities.Analysis
import data.entities.Analysis_5_6
import data.entities.Patient
import data.state.TypeBiomaterial
import java.awt.Dialog

@Composable
fun ApplicationScope.WindowCreatingForm(
    openDialogAddAnalysis: ()-> Unit,
    sizeWindow: WindowState = rememberWindowState(
        size = DpSize(1000.dp,800.dp),
        position = WindowPosition(Alignment.Center)
    ),
    dialogAddAnalyzes: @Composable (MutableList<Analysis>,MutableList<Analysis_5_6>)->Unit
) {
    val patient = remember { Patient() }

    println(patient.listAnalyzes.size)
    Window(
        onCloseRequest = ::exitApplication,
        title = "Создания бланка анализов",
        state = sizeWindow,
        icon = null
    ) {
        ViewCreatingForm(patient, openDialogAddAnalysis, patient::reset)
        dialogAddAnalyzes(patient.listAnalyzes, patient.listAnalyzes_5_6)
    }
}