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

    fun playerWinsAPoint(player: Player) {
        if (player !== playerOne && player !== playerTwo) {
            throw IllegalArgumentException("Player is not part of this game.")
        }

        val otherPlayer = if (player === playerOne) playerTwo else playerOne

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

    private fun playerWins(number: Int): String {
        playerOne.resetScore()
        playerTwo.resetScore()
        return "Player $number wins the match!"
    }



}
