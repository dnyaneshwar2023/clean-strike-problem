package models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlayGroundTest {
    @Test
    fun `it should create a game playground`() {
        val player1 = Player("Dnyaneshwar", CoinsCollection(0, 0), 0)
        val player2 = Player("Amaan", CoinsCollection(0, 0), 0)
        val playGround = PlayGround(player1, player2, CoinsCollection(1, 9))

        assertEquals(1, playGround.coins.redCoins)
        assertEquals(9, playGround.coins.blackCoins)
    }

    @Test
    fun `it should perform the multistrike with two black coins`() {
        val player1 = Player("Dnyaneshwar", CoinsCollection(0, 0), 0)
        val player2 = Player("Amaan", CoinsCollection(0, 0), 0)
        val playGround = PlayGround(player1, player2, CoinsCollection(1, 9))

        playGround.performTurn(player1, MultiStrike(CoinsCollection(0, 2)))

        assertEquals(2, player1.points)
    }

    @Test
    fun `it should perform the strike with a black coin`() {
        val player1 = Player("Dnyaneshwar", CoinsCollection(0, 0), 0)
        val player2 = Player("Amaan", CoinsCollection(0, 0), 0)
        val playGround = PlayGround(player1, player2, CoinsCollection(1, 9))

        playGround.performTurn(player1, Strike(CoinsCollection(0, 1)))

        assertEquals(1, player1.points)
    }
}
