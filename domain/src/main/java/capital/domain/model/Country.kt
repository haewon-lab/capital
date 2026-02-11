package capital.domain.model

data class Country(
    val code: String,
    val continent: String,
    val nameKo: String,
    val nameEn: String,
    val capitals: List<Capital>,
    val languages: List<String>
)
