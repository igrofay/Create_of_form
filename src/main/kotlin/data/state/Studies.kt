package data.state


enum class Studies(
    val nameRu: String
) {
    Hematological(
        "Гематологические\nисследования"
    ),
    Biochemical(
        "Биохимические\nисследования"
    ),
    Coagulation(
        "Коагулогические\nисследования"
    ),
    ELISA_diagnostics(
        "Иммуноферментная\nдиагностика"
    ),
    Chemical_microscopic(
        "Химико-микроскопические\nисследования"
    )
}