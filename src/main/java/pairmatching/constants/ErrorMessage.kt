package pairmatching.constants

enum class ErrorMessage(private val message: String) {
    PREFIX("[ERROR]"),
    ERROR_MATCHING_IMPOSSIBLE("${PREFIX.message} 매칭이 불가합니다."),
    ERRROR_MENU_OPTION("${PREFIX.message} 올바른 값을 다시 입력해주세요."),
    ERROR_PAIR_MATCHING_INPUT("${PREFIX.message} 예시의 형식대로 입력해주세요."),
    ERROR_MISSION_NAME("${PREFIX.message} 존재하지 않는 미션입니다.");

    fun getMessage(): String {
        return this.message
    }
}