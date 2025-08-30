import model.Game
import model.Player
import kotlin.test.Test
import kotlin.test.assertEquals

class GameTest {

    @Test
    fun `given a new game, when it starts, then the score is 0-0`() {
        val playerOne = Player()
        val playerTwo = Player()
        val match = Game(playerOne, playerTwo)

        assertEquals("0-0", match.getScore(), "Expected initial score to be 0-0, but got '${match.getScore()}'")
    }
}