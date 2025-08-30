import model.Player
import kotlin.test.Test
import kotlin.test.assertEquals


class PlayerTest {

    @Test
    fun `player should win a point and increase score`() {
        val player = Player()

        player.winsAPoint()

        assertEquals(15, player.getScore(), "Score should increase by 15")
    }
}