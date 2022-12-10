package pairmatching.constants

enum class Level(private val levelName: String, private val missions: List<String>) {
    LEVEL1("레벨1", listOf("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", listOf("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", listOf()),
    LEVEL4("레벨4", listOf("성능개선", "배포")),
    LEVEL5("레벨5", listOf());

    fun getLevelName(): String {
        return this.levelName
    }

    fun getMissions(): List<String> {
        return this.missions
    }
}