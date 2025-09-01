import model.Player
import kotlin.test.Test
import kotlin.test.assertEquals


class PlayerTest {

    @Test
    fun `given a player, when a point is won, then score increases by 15`() {
        // GIVEN
        val player = Player("Dummy")
        // WHEN
        player.winsAPoint()
        // THEN
        assertEquals(15, player.getScore(), "Score should increase by 15")
    }

    @Test
    fun `player starts with 0`() {
        val player = Player("Dummy")
        assertEquals(0, player.getScore())
    }

    @Test
    fun `player gets 15 after one point`() {
        val player = Player("Dummy")
        player.winsAPoint()
        assertEquals(15, player.getScore())
    }

    @Test
    fun `player gets 30 after two points`() {
        val player = Player("Dummy")
        repeat(2) { player.winsAPoint() }
        assertEquals(30, player.getScore())
    }

    @Test
    fun `player gets 40 after three points`() {
        val player = Player("Dummy")
        repeat(3) { player.winsAPoint() }
        assertEquals(40, player.getScore())
    }

    @Test
    fun `player maximum score is 40`() {
        val player = Player("Dummy")
        repeat(10) { player.winsAPoint() }
        assertEquals(40, player.getScore())
    }
}