import model.Game
import model.Player

fun main() {
    val playerOne = Player("Matthew")
    val playerTwo = Player("Sebastian")
    val game = Game(playerOne, playerTwo)
    game.scorePoint(playerOne) // 15-0
    game.scorePoint(playerTwo) // 15-15
    repeat(3) { game.scorePoint(playerOne) } // 40-15
    println(game.getScore()) // Matthew wins the match!
}