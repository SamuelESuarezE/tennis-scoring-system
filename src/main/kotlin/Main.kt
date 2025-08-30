import model.Game
import model.Player

fun main() {
    val playerOne = Player()
    val playerTwo = Player()
    val game = Game(playerOne, playerTwo)
    game.playerWinsAPoint(1) // 15-0
    game.playerWinsAPoint(2) // 15-15
    repeat(3) { game.playerWinsAPoint(1) } // 40-15
    println(game.getScore()) // Player 1 wins the match!
}