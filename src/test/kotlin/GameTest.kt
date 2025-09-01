import model.Game
import model.Player
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class GameTest {

    @Test
    fun `given a two players, when game starts, then the score is 0-0`() {
        // GIVEN
        val playerOne = Player("Dummy")
        val playerTwo = Player("Dummy2")
        // WHEN
        val match = Game(playerOne, playerTwo)
        // THEN
        assertEquals("0-0", match.getScore(), "Expected initial score to be 0-0, but got '${match.getScore()}'")
    }

    @Test
    fun `given two players, when both have 40, then game enters Deuce`() {
        // GIVEN
        val playerOne = Player("Dummy")
        val playerTwo = Player("Dummy2")
        // WHEN
        val match = Game(playerOne, playerTwo)
        repeat(3) { match.scorePoint(playerOne) }
        repeat(3) { match.scorePoint(playerTwo) }
        // THEN
        assertEquals("Deuce", match.getScore(), "Expected score to be 'Deuce', but got '${match.getScore()}'")
    }

    @Test
    fun `given a deuce, when a player wins a point, then they get advantage`() {
        // GIVEN
        val playerOne = Player("Dummy")
        val playerTwo = Player("Dummy2")
        val match = Game(playerOne, playerTwo)
        repeat(3) { match.scorePoint(playerOne) }
        repeat(3) { match.scorePoint(playerTwo) }
        // WHEN
        match.scorePoint(playerTwo)
        // THEN
        assertEquals("Advantage Dummy2", match.getScore(), "Expected score to be 'Advantage Dummy2', but got '${match.getScore()}'")
    }

    @Test
    fun `given a player with advantage, when they lose the next point, then scores returns to Deuce`() {
        // GIVEN
        val playerOne = Player("Dummy")
        val playerTwo = Player("Dummy2")
        val match = Game(playerOne, playerTwo)
        repeat(3) { match.scorePoint(playerOne) }
        repeat(4) { match.scorePoint(playerTwo) }
        // WHEN
        match.scorePoint(playerOne)
        // THEN
        assertEquals("Deuce", match.getScore(), "Expected score to be 'Deuce', but got '${match.getScore()}'")
    }

    @Test
    fun `given a player with advantage, when they win the next point, then they win the game`() {
        // GIVEN
        val playerOne = Player("Dummy")
        val playerTwo = Player("Dummy2")
        val match = Game(playerOne, playerTwo)
        repeat(3) { match.scorePoint(playerOne) }
        repeat(4) { match.scorePoint(playerTwo) }
        // WHEN
        match.scorePoint(playerTwo)
        //THEN
        assertEquals("Dummy2 wins the match!", match.getScore(), "Expected score to be 'Dummy2 wins the match!', but got '${match.getScore()}'")
    }

    @Test
    fun `given a started match, when a non-participating player wins a point, then an exception is thrown`() {
        // GIVEN
        val playerOne = Player("Dummy")
        val playerTwo = Player("Dummy2")
        val match = Game(playerOne, playerTwo)

        // WHEN - THEN
        val anotherPlayer = Player("DummyIntruder")
        assertFailsWith<IllegalArgumentException>("Should throw if player not in match") {
            match.scorePoint(anotherPlayer)
        }
    }
}