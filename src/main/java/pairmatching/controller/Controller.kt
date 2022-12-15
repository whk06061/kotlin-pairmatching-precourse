package pairmatching.controller

import pairmatching.constants.Course
import pairmatching.constants.MenuOption
import pairmatching.domain.*
import pairmatching.utils.RepeatInputProcess
import pairmatching.view.InputView
import pairmatching.view.OutputView

class Controller {

    private val outputView = OutputView()
    private val inputView = InputView()
    private val matchPair = MatchPairs()

    fun operate() {
        while (true) {
            when (readMenuOption()) {
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

    @Suppress("UNCHECKED_CAST")
    private fun matchPair() {
        outputView.printPairMatchingMent()
        val (course, level, mission) = RepeatInputProcess.repeat { inputView.readPairMatching() } as List<String>
        when (course) {
            Course.FRONTEND.getCourseName() -> {
                val levelPairs = PairsRepository.frontEndLevelPairs().find { it.levelName() == level }
                match(ReadFile().readFECrew(), levelPairs!!, mission)
            }

            else -> {
                val levelPairs = PairsRepository.backEndLevelPairs().find { it.levelName() == level }
                match(ReadFile().readBECrew(), levelPairs!!, mission)
            }
        }

    }

    private fun match(crews: List<String>, levelPairs: LevelPairs, mission: String) {
        val missionPairs: List<Set<String>> = levelPairs.getMissionPairsByMissionName(mission)
        if (missionPairs.isNotEmpty()) {
            val checkReMatch = readReMatch()
            if (checkReMatch) {
                // 미션 기존 매칭 정보 초기화
                levelPairs.deleteMissionPairsByMissionName(mission)
                // 재매칭
                levelPairs.setMissionPairsByMissionName(mission, matchPair.match(crews, levelPairs.getLevelPairs()))
                printMatchingResult(levelPairs, mission)
            }
        } else {
            levelPairs.setMissionPairsByMissionName(mission, matchPair.match(crews, levelPairs.getLevelPairs()))
            printMatchingResult(levelPairs, mission)
        }
    }

    private fun printMatchingResult(levelPair: LevelPairs, mission: String) {
        outputView.printMatchResult(levelPair.getMissionPairsByMissionName(mission))
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
        when (course) {
            Course.FRONTEND.getCourseName() -> printMatchingResult(
                PairsRepository.frontEndLevelPairs().find { it.levelName() == level }!!, mission
            )

            else -> printMatchingResult(PairsRepository.backEndLevelPairs().find { it.levelName() == level }!!, mission)
        }
    }

    private fun resetPair() {
        PairsRepository.reset()
        outputView.printResetMent()
    }
}