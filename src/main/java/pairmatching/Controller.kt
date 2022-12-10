package pairmatching

import pairmatching.constants.Course
import pairmatching.constants.Level
import pairmatching.constants.MenuOption
import pairmatching.domain.LevelPair
import pairmatching.domain.MatchPair
import pairmatching.domain.ReadFile
import pairmatching.utils.RepeatInputProcess
import pairmatching.view.InputView
import pairmatching.view.OutputView

class Controller {

    private val outputView = OutputView()
    private val inputView = InputView()
    private var frontEndPairs = mutableListOf<LevelPair>()
    private var backEndPairs = mutableListOf<LevelPair>()
    val matchPair = MatchPair()

    init {
        for (level in Level.values()) {
            val fePair = LevelPair()
            val bePair = LevelPair()
            frontEndPairs.add(fePair)
            backEndPairs.add(bePair)
        }
    }

    fun operate() {
        while (true) {
            val option = readMenuOption()
            when (option) {
                MenuOption.MATCHING_PAIR.getOption() -> matchPair()
                MenuOption.VIEW_PAIR.getOption() -> viewPair()
                MenuOption.RESET_PAIR.getOption() -> resetPair()
                MenuOption.QUIT.getOption() -> break
            }
        }
    }

    private fun readMenuOption(): String {
        outputView.printMenuMent()
        return RepeatInputProcess.repeat { inputView.readMenuOption() } as String
    }

    private fun matchPair() {
        outputView.printPairMatchingMent()
        val (course, level, mission) = inputView.readPairMatching()
        val levelIndex = when (level) {
            Level.LEVEL1.getLevelName() -> 0
            Level.LEVEL2.getLevelName() -> 1
            Level.LEVEL3.getLevelName() -> 2
            Level.LEVEL4.getLevelName() -> 3
            else -> 4
        }
        when (course) {
            Course.FRONTEND.getCourseName() -> {
                val crews = ReadFile().readFECrew()
                match(crews, frontEndPairs[levelIndex], mission)
            }

            else -> {
                val crews = ReadFile().readBECrew()
                match(crews, backEndPairs[levelIndex], mission)
            }
        }

    }

    private fun match(crews: List<String>, levelPair: LevelPair, mission: String) {
        if (levelPair.getMissionPairs(mission).isNotEmpty()) {
            val checkReMatch = readReMatch()
            if (checkReMatch) {
                levelPair.setMissionPairs(mission, listOf())
                levelPair.setMissionPairs(mission, matchPair.match(crews, levelPair.getLevelPairs()))
                printMatchingResult(levelPair, mission)
            }
        } else {
            levelPair.setMissionPairs(mission, matchPair.match(crews, levelPair.getLevelPairs()))
            printMatchingResult(levelPair, mission)
        }
    }

    private fun printMatchingResult(levelPair: LevelPair, mission: String) {
        outputView.printMatchResult(levelPair.getMissionPairs(mission))
    }

    private fun readReMatch(): Boolean {
        outputView.printReMatchMent()
        val input = inputView.readReMatch()
        if (input == "네") return true
        return false
    }

    private fun viewPair() {
        outputView.printPairMatchingMent()
        val (course, level, mission) = inputView.readPairMatching()
        val levelIndex = when (level) {
            Level.LEVEL1.getLevelName() -> 0
            Level.LEVEL2.getLevelName() -> 1
            Level.LEVEL3.getLevelName() -> 2
            Level.LEVEL4.getLevelName() -> 3
            else -> 4
        }
        when (course) {
            Course.FRONTEND.getCourseName() -> printMatchingResult(frontEndPairs[levelIndex], mission)
            else -> printMatchingResult(backEndPairs[levelIndex], mission)
        }
    }

    private fun resetPair() {
        frontEndPairs = mutableListOf()
        backEndPairs = mutableListOf()
        for (level in Level.values()) {
            val fePair = LevelPair()
            val bePair = LevelPair()
            frontEndPairs.add(fePair)
            backEndPairs.add(bePair)
        }
        outputView.printResetMent()
    }
}