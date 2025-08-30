import model.Game
import model.Player
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class GameTest {

    @Test
    fun `given a new game, when it starts, then the score is 0-0`() {
        val playerOne = Player()
        val playerTwo = Player()
        val match = Game(playerOne, playerTwo)

        assertEquals("0-0", match.getScore(), "Expected initial score to be 0-0, but got '${match.getScore()}'")
    }

    @Test
    fun `given two players, when both have 40, then game enters Deuce`() {
        val playerOne = Player()
        val playerTwo = Player()
        val match = Game(playerOne, playerTwo)
        repeat(3) { match.playerWinsAPoint(playerOne) }
        repeat(3) { match.playerWinsAPoint(playerTwo) }

        assertEquals("Deuce", match.getScore(), "Expected score to be 'Deuce', but got '${match.getScore()}'")
    }

    @Test
    fun `given a deuce, when a player wins a point, then they get advantage`() {
        val playerOne = Player()
        val playerTwo = Player()
        val match = Game(playerOne, playerTwo)
        repeat(3) { match.playerWinsAPoint(playerOne) }
        repeat(4) { match.playerWinsAPoint(playerTwo) }

        assertEquals("Advantage Player 2", match.getScore(), "Expected score to be 'Advantage Player playerTwo', but got '${match.getScore()}'")
    }

    @Test
    fun `given a player with advantage, when they lose the next point, then scores returns to Deuce`() {
        val playerOne = Player()
        val playerTwo = Player()
        val match = Game(playerOne, playerTwo)
        repeat(3) { match.playerWinsAPoint(playerOne) }
        repeat(4) { match.playerWinsAPoint(playerTwo) }
        match.playerWinsAPoint(playerOne)

        assertEquals("Deuce", match.getScore(), "Expected score to be 'Deuce', but got '${match.getScore()}'")
    }

    @Test
    fun `given a player with advantage, when they win the next point, then they win the game`() {
        val playerOne = Player()
        val playerTwo = Player()
        val match = Game(playerOne, playerTwo)
        repeat(3) { match.playerWinsAPoint(playerOne) }
        repeat(5) { match.playerWinsAPoint(playerTwo) }

        assertEquals("Player 2 wins the match!", match.getScore(), "Expected score to be 'Player playerTwo wins the match!', but got '${match.getScore()}'")
    }

    @Test
    fun `when a non-participating player wins a point, then and exception is thrown`() {
        val playerOne = Player()
        val playerTwo = Player()
        val match = Game(playerOne, playerTwo)
        val anotherPlayer = Player()

        assertFailsWith<IllegalArgumentException>("Should throw if player not in match") {
            match.playerWinsAPoint(anotherPlayer)
        }
    }
}