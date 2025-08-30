import model.Match
import model.Player

fun main() {
    val playerOne = Player("Samuel")
    val playerTwo = Player("Matthew")
    val match = Match(playerOne, playerTwo)
    playerOne.winsAPoint()
    match.displayScore()
}