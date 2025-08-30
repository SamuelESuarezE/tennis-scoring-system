package model

class Match(
    private val playerOne: Player,
    private val playerTwo: Player,
    private var deuce: Boolean = false
) {
    fun displayScore() {

        if (playerOne.won) {
            playerWins(1)
            return
        }

        if (playerTwo.won) {
            playerWins(2)
            return
        }

        if (playerOne.advantage) println("Advantage Player 1")
        else if (playerTwo.advantage) println("Advantage Player 2")
        else if (deuce) println("Deuce")
        else println("${playerOne.getScore()}-${playerTwo.getScore()}")
    }

    fun playerWinsAPoint(number: Int) {
        if (number !in 1..2) {
            println("Invalid player number, use 1 or 2")
            return
        }

        val player: Player
        val otherPlayer: Player
        if (number == 1) {
            player = playerOne
            otherPlayer = playerTwo
        } else {
            player = playerTwo
            otherPlayer = playerOne
        }

        if (player.advantage) {
            player.won = true
            return
        }

        if (deuce) {
            player.advantage = true
            deuce = false
            return
        }

        if (otherPlayer.advantage) {
            deuce = true
            otherPlayer.advantage = false
            return
        }

        if (player.getScore() == 40) {
            player.won = true
            return
        }

        player.winsAPoint()

        if (player.getScore() == 40 && otherPlayer.getScore() == 40) {
            deuce = true
            return
        }
    }

    private fun playerWins(number: Int) {
        println("Player $number wins the match! 🎉")
        playerOne.resetScore()
        playerTwo.resetScore()
    }



}
