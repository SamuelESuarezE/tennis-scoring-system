import model.Game
import model.Player

fun main() {
    val playerOne = Player()
    val playerTwo = Player()
    val game = Game(playerOne, playerTwo)
    game.playerWinsAPoint(playerOne) // 15-0
    game.playerWinsAPoint(playerTwo) // 15-15
    repeat(3) { game.playerWinsAPoint(playerOne) } // 40-15
    println(game.getScore()) // Player 1 wins the match!
}