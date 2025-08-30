import model.Match
import model.Player

fun main() {
    val playerOne = Player()
    val playerTwo = Player()
    val match = Match(playerOne, playerTwo)
    match.playerWinsAPoint(1)
    match.playerWinsAPoint(2)
    match.playerWinsAPoint(1)
    match.playerWinsAPoint(1)
    match.playerWinsAPoint(2)
    match.playerWinsAPoint(2)
    match.playerWinsAPoint(2)
    match.playerWinsAPoint(1)


    match.displayScore()
}