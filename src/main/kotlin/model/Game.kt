package model

class Game(
    private val playerOne: Player,
    private val playerTwo: Player,
    private var deuce: Boolean = false
) {
    fun getScore(): String {

        if (playerOne.won) {
            return playerWins(1)
        }

        if (playerTwo.won) {
            return playerWins(2)
        }

        return if (playerOne.advantage) "Advantage Player 1"
        else if (playerTwo.advantage) "Advantage Player 2"
        else if (deuce) "Deuce"
        else "${playerOne.getScore()}-${playerTwo.getScore()}"
    }

    fun playerWinsAPoint(number: Int): String? {
        if (number !in 1..2) {
            return "Invalid player number, use 1 or 2"
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
            return null
        }

        if (deuce) {
            player.advantage = true
            deuce = false
            return null
        }

        if (otherPlayer.advantage) {
            deuce = true
            otherPlayer.advantage = false
            return null
        }

        if (player.getScore() == 40) {
            player.won = true
            return null
        }

        player.winsAPoint()

        if (player.getScore() == 40 && otherPlayer.getScore() == 40) {
            deuce = true
            return null
        }

        return null
    }

    private fun playerWins(number: Int): String {
        playerOne.resetScore()
        playerTwo.resetScore()
        return "Player $number wins the match!"
    }



}
