package pairmatching.constants

enum class PairMatchingMent(private val message: String) {
    DIVISION("#############################################"),
    COURSE("과정: ${Course.BACKEND.getCourseName()} | ${Course.FRONTEND.getCourseName()}"),
    MISSION(
        "미션:\n" +
                "  - ${Level.LEVEL1.getLevelName()}: ${Level.LEVEL1.getMissions()[0]} | ${Level.LEVEL1.getMissions()[1]} | ${Level.LEVEL1.getMissions()[2]}\n" +
                "  - ${Level.LEVEL2.getLevelName()}: ${Level.LEVEL2.getMissions()[0]} | ${Level.LEVEL2.getMissions()[1]} |  ${Level.LEVEL2.getMissions()[2]}\n" +
                "  - ${Level.LEVEL3.getLevelName()}: \n" +
                "  - ${Level.LEVEL4.getLevelName()}:  ${Level.LEVEL4.getMissions()[0]} | ${Level.LEVEL4.getMissions()[1]}\n" +
                "  - ${Level.LEVEL5.getLevelName()}: "
    ),
    INPUT_MENT(
        "과정, 레벨, 미션을 선택하세요.\n" +
                "ex) 백엔드, 레벨1, 자동차경주"
    ),
    REMATCH_MENT(
        "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
                "네 | 아니오"
    ),
    MATCHING_RESULT_MENT("페어 매칭 결과입니다."),
    RESET("초기화 되었습니다.");

    fun getMessage(): String {
        return this.message
    }
}