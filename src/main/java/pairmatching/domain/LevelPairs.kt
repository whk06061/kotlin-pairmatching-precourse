package pairmatching.domain

class LevelPairs(private val level: String) {

    private var missionPairs = mutableMapOf<String, List<Set<String>>>()

    fun levelName(): String {
        return level
    }

    fun setMissionPairsByMissionName(mission: String, pairs: List<Set<String>>) {
        missionPairs[mission] = pairs
    }

    fun getMissionPairsByMissionName(mission: String): List<Set<String>> {
        return this.missionPairs.getOrDefault(mission, listOf())
    }

    fun getLevelPairs(): List<List<Set<String>>> {
        val result = mutableListOf<List<Set<String>>>()
        for (value in missionPairs.values) {
            result.add(value)
        }
        return result
    }

    fun deleteMissionPairsByMissionName(mission: String) {
        missionPairs.entries.removeIf { it.key == mission }
    }
}