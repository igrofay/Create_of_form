import androidx.compose.ui.res.useResource
import data.entities.Analysis
import data.entities.Patient
import org.apache.poi.util.Units
import org.apache.poi.xwpf.usermodel.*
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
import java.awt.Desktop
import java.io.File
import java.io.FileOutputStream
import java.math.BigInteger
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

var stamp = "stamp.png"

var header1 = "header_12.txt"
var header2 = "header_8.txt"
var header3 = "header_10.txt"

var output = "C:\\resDocFolder\\"

fun createDocx(data: Patient) {


    //создаём документ епта
    var document = XWPFDocument()

    //ставим отступы линейки епта
    //567 примерно 1см
    val sectPr = document.document.body.addNewSectPr()
    val ctpagemar = sectPr.addNewPgMar()
    ctpagemar.left = BigInteger.valueOf(1134)
    ctpagemar.right = BigInteger.valueOf(1134)


    val title = document.createParagraph()
    title.alignment = ParagraphAlignment.CENTER
    title.spacingAfter = 0
    val titleRun = title.createRun()
    titleRun.setText(convertTextFileToString(header1))
    titleRun.fontFamily = "Times New Roman"
    titleRun.fontSize = 12


    convertTextFileToString(header2)?.split("\n")?.forEach {
        val subTitle = document.createParagraph()
        subTitle.alignment = ParagraphAlignment.CENTER
        subTitle.spacingAfter = 0
        val subTitleRun = subTitle.createRun()
        subTitleRun.setText(it)
        subTitleRun.fontFamily = "Times New Roman"
        subTitleRun.fontSize = 8
        subTitleRun.textPosition = 1
    }

    val contacts = document.createParagraph()
    contacts.alignment = ParagraphAlignment.CENTER
    contacts.spacingAfter = 0
    val contactsRun = contacts.createRun()
    contactsRun.setText(convertTextFileToString(header3))
    contactsRun.fontFamily = "Times New Roman"
    contactsRun.fontSize = 10
    contactsRun.textPosition = 2

    val line = document.createParagraph()
    line.alignment = ParagraphAlignment.CENTER
    line.spacingAfter = 0
    val lineRun = line.createRun()
    lineRun.setText("___________________________________________________________________________________________________")
    lineRun.fontFamily = "Times New Roman"
    lineRun.fontSize = 10
    lineRun.textPosition = 55

    val patientFamiliya = document.createParagraph()
    patientFamiliya.alignment = ParagraphAlignment.LEFT
    patientFamiliya.spacingAfter = 0
    val patientFamiliyaRun = patientFamiliya.createRun()
    patientFamiliyaRun.setText("Пациент:  ${data.surname.value}")
    patientFamiliyaRun.fontFamily = "Times New Roman"
    patientFamiliyaRun.fontSize = 11
    patientFamiliyaRun.textPosition = 0

    val patientName = document.createParagraph()
    patientName.alignment = ParagraphAlignment.LEFT
    patientName.spacingAfter = 0
    val patientNameRun = patientName.createRun()
    patientNameRun.setText("                  ${data.name.value}")
    patientNameRun.fontFamily = "Times New Roman"
    patientNameRun.fontSize = 11
    patientNameRun.textPosition = 0


    val patientOtchestvo = document.createParagraph()
    patientOtchestvo.alignment = ParagraphAlignment.LEFT
    patientOtchestvo.spacingAfter = 0
    val patientOtchestvoRun = patientOtchestvo.createRun()
    patientOtchestvoRun.setText("                  ${data.patronymic.value}")
    patientOtchestvoRun.fontFamily = "Times New Roman"
    patientOtchestvoRun.fontSize = 11
    patientOtchestvoRun.textPosition = 0



    val patientSex = document.createParagraph()
    patientSex.alignment = ParagraphAlignment.LEFT
    patientSex.spacingAfter = 0
    val patientSexRun = patientSex.createRun()
    patientSexRun.setText("                  Пол: ${if (data.isMan.value) "мужской" else "женский"}")
    patientSexRun.fontFamily = "Times New Roman"
    patientSexRun.fontSize = 11
    patientSexRun.textPosition = 0

    val patientAge = document.createParagraph()
    patientAge.alignment = ParagraphAlignment.LEFT
    patientAge.spacingAfter = 0
    val patientAgeRun = patientAge.createRun()
    patientAgeRun.setText("                  Возраст: ${data.age.value}")
    patientAgeRun.fontFamily = "Times New Roman"
    patientAgeRun.fontSize = 11
    patientAgeRun.textPosition = 0

    val orderer = document.createParagraph()
    orderer.alignment = ParagraphAlignment.LEFT
    orderer.spacingAfter = 0
    val ordererRun = orderer.createRun()
    ordererRun.setText("Заказчик (контрагент)  ГАУЗ «ОЦМР»")
    ordererRun.fontFamily = "Times New Roman"
    ordererRun.fontSize = 11
    ordererRun.textPosition = 2


    val line2 = document.createParagraph()
    line2.alignment = ParagraphAlignment.CENTER
    line2.spacingAfter = 0
    val lineRun2 = line2.createRun()
    lineRun2.setText("___________________________________________________________________________________________________")
    lineRun2.fontFamily = "Times New Roman"
    lineRun2.fontSize = 10
    lineRun2.textPosition = 20


    val biomaterial = document.createParagraph()
    biomaterial.alignment = ParagraphAlignment.LEFT
    biomaterial.spacingAfter = 0
    val biomaterialRun = biomaterial.createRun()
    biomaterialRun.setText("Вид  биоматериала: ${data.typeBiomat.value}")
    biomaterialRun.fontFamily = "Times New Roman"
    biomaterialRun.fontSize = 11
    biomaterialRun.textPosition = 0

    val line3 = document.createParagraph()
    line3.alignment = ParagraphAlignment.CENTER
    line3.spacingAfter = 0
    val lineRun3 = line3.createRun()
    lineRun3.setText("___________________________________________________________________________________________________")
    lineRun3.fontFamily = "Times New Roman"
    lineRun3.fontSize = 10
    lineRun3.textPosition = 20


    val list = mutableListOf<MutableList<Analysis>>()

    var previousAnalyzeId = ""
    var currentAnalyzeId = ""
    var currentAnalyzeName = ""
    if (data.listAnalyzes.size > 0) {
        data.listAnalyzes.forEach { analyzeIT ->

            NameRes.values().forEach {
                if (it.id in analyzeIT.id.substring(0, 3)) {

                    currentAnalyzeId = it.id
                    currentAnalyzeName = it.nameRu

                    if (currentAnalyzeId != previousAnalyzeId) {
                        list.add(mutableListOf())
                    }

                    list[list.lastIndex] += analyzeIT

                    previousAnalyzeId = currentAnalyzeId

                }
            }
        }
    }

    list.forEach {
        var name = ""
        NameRes.values().forEach { itit ->
            if (it[0].id.substring(0,3) == itit.id) {
                name = itit.nameRu
            }
        }

        val dDimer = document.createParagraph()
        dDimer.alignment = ParagraphAlignment.LEFT
        dDimer.spacingAfter = 0
        var dDimerRun = dDimer.createRun()
        dDimerRun.setText("Название/показатель: $name")
        dDimerRun.fontFamily = "Times New Roman"
        dDimerRun.fontSize = 11
        dDimerRun.textPosition = 20

        //create table
        var table = document.createTable()
        //create first row
        var tableRowOne = table.getRow(0)
        var ftr = tableRowOne.getCell(0)
        //create second row
        var lol = tableRowOne.addNewTableCell()
        var loll = tableRowOne.addNewTableCell()

        it.forEach { listIT ->
            //fill row
            var l = ftr.addParagraph()
            l.alignment = ParagraphAlignment.LEFT
            l.spacingAfter = 0
            var lRun = l.createRun()
            lRun.setText(listIT.name)
            lRun.fontFamily = "Times New Roman"
            lRun.fontSize = 11
            lRun.textPosition = 10
        }
        ftr.removeParagraph(0)

        it.forEach { listIT ->
            var l2 = lol.addParagraph()
            l2.alignment = ParagraphAlignment.LEFT
            l2.spacingAfter = 0
            var l2Run = l2.createRun()
            l2Run.setText(listIT.result.value)
            l2Run.fontFamily = "Times New Roman"
            l2Run.fontSize = 11
            l2Run.textPosition = 10
        }
        lol.removeParagraph(0)

        it.forEach { listIT ->
            //fill third row
            var l3 = loll.addParagraph()
            l3.alignment = ParagraphAlignment.LEFT
            l3.spacingAfter = 0
            var l3Run = l3.createRun()
            if (listIT.referenceValue == null) {
                l3Run.setText("")
            } else {
                l3Run.setText(listIT.referenceValue)
            }
            l3Run.fontFamily = "Times New Roman"
            l3Run.fontSize = 11
            l3Run.textPosition = 10
        }
        loll.removeParagraph(0)


        table.rows.forEach { rowIT ->
            rowIT.tableCells.forEach {
                it.setWidth("4000")
            }
        }

        val space = document.createParagraph()
        space.alignment = ParagraphAlignment.CENTER
        space.spacingAfter = 0
        val spaceRun = space.createRun()
        spaceRun.setText("")
        spaceRun.fontFamily = "Times New Roman"
        spaceRun.fontSize = 10
        spaceRun.textPosition = 20
    }


    if (data.listAnalyzes_5_6.size > 0) {

        val dDimer = document.createParagraph()
        dDimer.alignment = ParagraphAlignment.LEFT
        dDimer.spacingAfter = 0
        var dDimerRun = dDimer.createRun()
        dDimerRun.setText("Название/показатель: Анализ мочи по Зимницкому")
        dDimerRun.fontFamily = "Times New Roman"
        dDimerRun.fontSize = 11
        dDimerRun.textPosition = 20

        //create table
        var table = document.createTable()
        //create first row
        var tableRowOne = table.getRow(0)
        var first = tableRowOne.getCell(0)
        var sec = tableRowOne.addNewTableCell()
        var third = tableRowOne.addNewTableCell()
        var four = tableRowOne.addNewTableCell()
        data.listAnalyzes_5_6.forEach {

            val firstFill = first.addParagraph()
            firstFill.alignment = ParagraphAlignment.LEFT
            firstFill.spacingAfter = 0
            val firstRun = firstFill.createRun()
            firstRun.setText(it.name)
            firstRun.fontFamily = "Times New Roman"
            firstRun.fontSize = 11
            firstRun.textPosition = 10

            val secFill = sec.addParagraph()
            secFill.alignment = ParagraphAlignment.LEFT
            secFill.spacingAfter = 0
            val secFillRun = secFill.createRun()
            secFillRun.setText(it.hours.value)
            secFillRun.fontFamily = "Times New Roman"
            secFillRun.fontSize = 11
            secFillRun.textPosition = 10

            val thirdFill = third.addParagraph()
            thirdFill.alignment = ParagraphAlignment.LEFT
            thirdFill.spacingAfter = 0
            val thirdFillRun = thirdFill.createRun()
            thirdFillRun.setText(it.specificGravity.value)
            thirdFillRun.fontFamily = "Times New Roman"
            thirdFillRun.fontSize = 11
            thirdFillRun.textPosition = 10

            val fourFill = four.addParagraph()
            fourFill.alignment = ParagraphAlignment.LEFT
            fourFill.spacingAfter = 0
            val fourFillRun = fourFill.createRun()
            fourFillRun.setText(it.quantity.value)
            fourFillRun.fontFamily = "Times New Roman"
            fourFillRun.fontSize = 11
            fourFillRun.textPosition = 10

        }

        first.removeParagraph(0)
        sec.removeParagraph(0)
        third.removeParagraph(0)
        four.removeParagraph(0)

        table.rows.forEach { rowIT ->
            rowIT.tableCells.forEach {
                it.setWidth("4000")
            }
        }

    }

    val space = document.createParagraph()
    space.alignment = ParagraphAlignment.CENTER
    space.spacingAfter = 0
    val spaceRun = space.createRun()
    spaceRun.setText("")
    spaceRun.fontFamily = "Times New Roman"
    spaceRun.fontSize = 10
    spaceRun.textPosition = 20

    val comment = document.createParagraph()
    comment.alignment = ParagraphAlignment.LEFT
    comment.spacingAfter = 0
    var commentRun = comment.createRun()
    commentRun.setText("Комментарий: ${data.comment.value}")
    commentRun.fontFamily = "Times New Roman"
    commentRun.fontSize = 11
    commentRun.textPosition = 25

    val date = document.createParagraph()
    date.alignment = ParagraphAlignment.LEFT
    date.spacingAfter = 0
    val dateRun = date.createRun()
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val formatted = current.format(formatter)
    dateRun.setText("Отчет создан: $formatted")
    dateRun.fontFamily = "Times New Roman"
    dateRun.fontSize = 11
    dateRun.textPosition = 18


    var run: XWPFRun?
    val anchor: CTAnchor
    //behind text
    var paragraph: XWPFParagraph = document.createParagraph()
    paragraph.alignment = ParagraphAlignment.LEFT
    run = paragraph.createRun()
    run.fontFamily = "Times New Roman"
    run.setText("Заведующая лабораторией:      ")


    useResource(stamp){
        run?.addPicture(it, Document.PICTURE_TYPE_JPEG, stamp, Units.toEMU(100.0), Units.toEMU(33.0))
    }



    run = paragraph.createRun()
    run.fontFamily = "Times New Roman"
    run.setText("                                                                      Вагапова Г.Р")
    paragraph = document.createParagraph()


    val dataTime = LocalDateTime.now()

    val f = File(output)
    f.mkdir()
    var file = File(output + data.name.value + " " + data.surname.value + " " + formatted + " " + dataTime.hour + "'" + dataTime.minute + ".docx")
    val out = FileOutputStream(file)
    document.write(out)
    out.close()
    document.close()
    if (Desktop.isDesktopSupported()) {
        val desktop = Desktop.getDesktop()
        if (desktop.isSupported(Desktop.Action.OPEN)) {
            desktop.open(file)
        }
    }

}

fun convertTextFileToString(fileName: String?): String {
    useResource(fileName!!){ inputStream ->
        return  inputStream.bufferedReader().use { it.readText() }
    }
}



enum class NameRes(val nameRu: String, val id: String) {
    en1_1("Общий (клинический) анализ крови", "1.1"),
    en1_2("Ретикулоциты", "1.2"),
    en1_3("Скорость оседания эритроцитов (СОЭ)", "1.3"),
    en2_1("Биохимический анализ крови", "2.1"),
    en3_1("Исследование уровня фибриногена в крови", "3.1"),
    en3_2("Определение протромбинового (тромбопластинового) времени в крови или плазме (ПТВ)", "3.2"),
    en3_3("Определение Активированного частичного тромбопластинового времени (АЧТВ)", "3.3"),
    en3_4("Определение концентрации D-димера в крови", "3.4"),
    en4_1("Оценка функции щитовидной железы", "4.1"),
    en4_2("Опухолевые маркеры", "4.2"),
    en4_3("Кардиомаркеры", "4.3"),
    en4_4("Вирусные гепатиты", "4.4"),
    en4_5("Сифилис", "4.5"),
    en5_1("Общий (клинический) анализ мочи", "5.1"),
    en5_2("Исследование мочи на белок Бенс-Джонса", "5.2"),
    en5_3("Микроскопическое исследование кала на яйца и личинки гельминтов", "5.3"),
    en5_4("Исследование кала на скрытую кровь", "5.4"),
    en5_5("Общий анализ мокроты", "5.5"),
    en5_6("Анализ мочи по Зимницкому", "5.6"),
    en5_7("Анализ мочи по Нечипоренко", "5.7")
}