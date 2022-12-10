package pairmatching.view

import pairmatching.constants.MenuMent

class OutputView {

    fun printMenuMent() {
        println(MenuMent.CHOOSE_MENU.getMessage())
        println(MenuMent.MENU1.getMessage())
        println(MenuMent.MENU2.getMessage())
        println(MenuMent.MENU3.getMessage())
        println(MenuMent.QUIT.getMessage())
    }

    fun printErrorMessage(message:String){
        println(message)
    }
}