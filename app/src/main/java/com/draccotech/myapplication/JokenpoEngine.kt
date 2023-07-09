package com.draccotech.myapplication

import kotlin.random.Random


enum class Result {
    WIN, DRAW, LOSS
}

class JokenpoEngine(private val availablePlays: Array<String>) {

    /*
        [0] -> Papel
        [1] -> Tesoura
        [2] -> Pedra
     */
    fun calculateResult(playerPlay: String): Result{
        val aiPlay = getAIPlay()

        return when{
            playerPlay == availablePlays[0] && aiPlay == availablePlays[1] -> Result.LOSS
            playerPlay == availablePlays[0] && aiPlay == availablePlays[2] -> Result.WIN
            playerPlay == availablePlays[1] && aiPlay == availablePlays[0] -> Result.WIN
            playerPlay == availablePlays[1] && aiPlay == availablePlays[2] -> Result.LOSS
            playerPlay == availablePlays[2] && aiPlay == availablePlays[0] -> Result.LOSS
            playerPlay == availablePlays[2] && aiPlay == availablePlays[1] -> Result.WIN
            else -> Result.DRAW
        }
    }

    private fun getAIPlay(): String {
        val playIndex = Random.nextInt(0, 2)

        return availablePlays[playIndex]
    }


}