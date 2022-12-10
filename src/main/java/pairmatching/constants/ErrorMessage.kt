package pairmatching.constants

enum class ErrorMessage(private val message: String) {
    PREFIX("[ERROR]"),
    ERROR_MATCHING_IMPOSSIBLE("${PREFIX.message} 매칭이 불가합니다.");

    fun getMessage(): String {
        return this.message
    }
}