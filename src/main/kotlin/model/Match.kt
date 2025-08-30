package model

class Match(
    private val playerOne: Player,
    private val playerTwo: Player,
    private var deuce: Boolean = false
) {
    fun displayScore() {
        if (playerOne.advantage) println("Advantage P1: ${playerOne.name}")
        else if (playerTwo.advantage) println("Advantage P2: ${playerTwo.name}")
        else if (deuce) println("Deuce")
        println("${playerOne.getScore()}-${playerTwo.getScore()}")
    }
}
