package pairmatching.constants

enum class MenuOption(private val option: String) {
    MATCHING_PAIR("1"),
    VIEW_PAIR("2"),
    RESET_PAIR("3"),
    QUIT("Q");

    fun getOption(): String {
        return this.option
    }

}