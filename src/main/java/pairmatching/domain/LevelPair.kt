package pairmatching.domain

class LevelPair {

    private var missionPairs = mutableMapOf<String, List<Set<String>>>()

    fun setMissionPairs(mission: String, pairs: List<Set<String>>) {
        missionPairs[mission] = pairs
    }

    fun getMissionPairs(mission: String): List<Set<String>> {
        return this.missionPairs.getOrDefault(mission, listOf())
    }

    fun getLevelPairs(): List<List<Set<String>>> {
        val result = mutableListOf<List<Set<String>>>()
        for (value in missionPairs.values) {
            result.add(value)
        }
        return result
    }
}