package pairmatching.constants

enum class Course(private val courseName: String) {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    fun getName(): String {
        return this.courseName
    }
}