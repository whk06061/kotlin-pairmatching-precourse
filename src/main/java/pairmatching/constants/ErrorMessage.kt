package pairmatching.constants

enum class ErrorMessage(private val message: String) {
    PREFIX("[ERROR]"),
    ERROR_MATCHING_IMPOSSIBLE("${PREFIX.message} 매칭이 불가합니다."),
    ERRROR_MENU_OPTION("${PREFIX.message} 올바른 값을 다시 입력해주세요.");

    fun getMessage(): String {
        return this.message
    }
}