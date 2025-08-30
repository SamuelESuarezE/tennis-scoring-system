import model.Player
import kotlin.test.Test
import kotlin.test.assertEquals


class PlayerTest {

    @Test
    fun `given a player, when a point is won, then score increases by 15`() {
        val player = Player()
        player.winsAPoint()

        assertEquals(15, player.getScore(), "Score should increase by 15")
    }

    @Test
    fun `given a player, when they win multiple points, then their score progresses as 0, 15, 30 and 40`() {
        val player = Player()
        assertEquals(0, player.getScore(), "Initial score must be 0 (Love)")
        player.winsAPoint()
        assertEquals(15, player.getScore(), "Expected score to be 15 after one points")
        player.winsAPoint()
        assertEquals(30, player.getScore(), "Expected score to be 30 after two points")
        player.winsAPoint()
        assertEquals(40, player.getScore(), "Expected score to be 40 after three points")
        player.winsAPoint()
        assertEquals(40, player.getScore(), "Maximum score is 40")
    }
}