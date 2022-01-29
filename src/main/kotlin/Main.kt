import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.application
import creating_form.WindowCreatingForm
import data.entities.Patient
import data.from_file.DataFromFile
import list_analyzes.DialogListAnalyzes

lateinit var allData: DataFromFile

fun main() = application {
    val patient = remember { Patient() }
    allData = DataFromFile(patient.isMan)
    var visibleDialog by remember {
        mutableStateOf(false)
    }
    WindowCreatingForm(
        patient,
        openDialogAddAnalysis = { visibleDialog = true},
    ) { analyses, analyses_5_6 ->
        DialogListAnalyzes(
            visible = visibleDialog,
            closeDialog = {
                visibleDialog = false
            },
            listAnalyzes = analyses,
            listAnalyzes_5_6 = analyses_5_6
        )
    }
}


