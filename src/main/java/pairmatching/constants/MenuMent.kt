package pairmatching.constants

enum class MenuMent(private val message: String) {
    CHOOSE_MENU("기능을 선택하세요."),
    MENU1("1. 페어 매칭"),
    MENU2("2. 페어 조회"),
    MENU3("3. 페어 초기화"),
    QUIT("Q. 종료");

    fun getMessage(): String {
        return this.message
    }
}