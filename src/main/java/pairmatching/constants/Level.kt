package pairmatching.constants

enum class Level(private val levelName: String) {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    fun getName(): String {
        return this.levelName
    }
}