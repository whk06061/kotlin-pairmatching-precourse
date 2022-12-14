package pairmatching.domain

import pairmatching.constants.Level

object PairsRepository {
    private var frontEndLevelPairs = mutableListOf<LevelPairs>()
    private var backEndLevelPairs = mutableListOf<LevelPairs>()

    init {
        for (level in Level.values()) {
            frontEndLevelPairs.add(LevelPairs(level.getLevelName()))
            backEndLevelPairs.add(LevelPairs(level.getLevelName()))
        }
    }

    fun frontEndLevelPairs(): List<LevelPairs> {
        return frontEndLevelPairs
    }

    fun backEndLevelPairs(): List<LevelPairs> {
        return backEndLevelPairs
    }

    fun reset() {
        for ((index, level) in Level.values().withIndex()) {
            frontEndLevelPairs[index] = LevelPairs(level.getLevelName())
            backEndLevelPairs[index] = LevelPairs(level.getLevelName())
        }
    }
}