package models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlayGroundTest {
    @Test
    fun `it should create a game playground`() {
        val player1 = Player("Dnyaneshwar", 0, 0)
        val player2 = Player("Amaan", 0, 0)
        val playGround = PlayGround(player1, player2, CoinsCollection(1, 9))

        assertEquals(1,playGround.coins.redCoins)
        assertEquals(9,playGround.coins.blackCoins)
    }
}
