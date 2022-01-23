import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.application
import creating_form.WindowCreatingForm
import list_analyzes.DialogListAnalyzes

fun main() = application {
    var visibleDialog by remember {
        mutableStateOf(false)
    }
    WindowCreatingForm(
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


