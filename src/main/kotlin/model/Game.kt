package model

class Game(
    private val playerOne: Player,
    private val playerTwo: Player
) {

    private var deuce: Boolean = false
    private var advantage: Player? = null
    private var winner: Player? = null

    fun getScore(): String {
        if (winner != null) {
            return playerWins(winner!!.name)
        }

        if (advantage != null) {
            return "Advantage ${advantage!!.name}"
        }

        if (deuce) return "Deuce"

        return "${playerOne.getScore()}-${playerTwo.getScore()}"
    }

    fun scorePoint(player: Player) {
        if (player !== playerOne && player !== playerTwo) {
            throw IllegalArgumentException("Player is not part of this game.")
        }

        val otherPlayer = if (player === playerOne) playerTwo else playerOne

        if (deuce) {
            advantage = player
            deuce = false
            return
        }

        when (advantage) {
            player -> {
                winner = player
                return
            }
            otherPlayer -> {
                deuce = true
                advantage = null
                return
            }
        }

        if (player.getScore() == 40) {
            winner = player
            return
        }

        player.winsAPoint()

        if (player.getScore() == 40 && otherPlayer.getScore() == 40) {
            deuce = true
            return
        }
    }

    private fun playerWins(name: String): String {
        playerOne.resetScore()
        playerTwo.resetScore()
        advantage = null
        winner = null
        return "$name wins the match!"
    }
}
