package pairmatching

import pairmatching.utils.RepeatInputProcess
import pairmatching.view.InputView
import pairmatching.view.OutputView

class Controller {

    private val outputView = OutputView()
    private val inputView = InputView()

    fun operate() {
        readMenuOption()
    }

    private fun readMenuOption(): String {
        outputView.printMenuMent()
        return RepeatInputProcess.repeat { inputView.readMenuOption() } as String
    }
}