package pairmatching.utils

import pairmatching.view.OutputView

object RepeatInputProcess {
    fun repeat(inputProcess: () -> Any): Any {
        val outputView = OutputView()
        do {
            try {
                return inputProcess()
            } catch (e: Exception) {
                outputView.printErrorMessage(e.message.toString())
            }
        } while (true)
    }
}