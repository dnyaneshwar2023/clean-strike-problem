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

    @Test
    fun `it should return null after given the game is drawn`() {
        val player1 = Player("Dnyaneshwar", CoinsCollection(0, 0), 0)
        val player2 = Player("Amaan", CoinsCollection(0, 0), 0)
        val playGround = PlayGround(player1, player2, CoinsCollection(1, 9))
        playGround.performTurn(player1, MultiStrike(pocketedCoins = CoinsCollection(0,3)))
        playGround.performTurn(player2, MultiStrike(pocketedCoins = CoinsCollection(0,3)))
        playGround.performTurn(player1, MultiStrike(pocketedCoins = CoinsCollection(0,3)))
        playGround.performTurn(player2, RedStrike(pocketedCoins = CoinsCollection(1,0)))

        val winner = playGround.getGameResult()


        assertEquals(null, winner)
    }

    @Test
    fun `it should return winner after given the result is not draw`() {
        val player1 = Player("Dnyaneshwar", CoinsCollection(0, 0), 0)
        val player2 = Player("Amaan", CoinsCollection(0, 0), 0)
        val playGround = PlayGround(player1, player2, CoinsCollection(1, 9))
        playGround.performTurn(player1, MultiStrike(pocketedCoins = CoinsCollection(0,4)))
        playGround.performTurn(player2, MultiStrike(pocketedCoins = CoinsCollection(0,2)))
        playGround.performTurn(player1, MultiStrike(pocketedCoins = CoinsCollection(0,3)))
        playGround.performTurn(player2, StrikerStrike(CoinsCollection(0,0)))
        playGround.performTurn(player1, RedStrike(pocketedCoins = CoinsCollection(1,0)))

        val winner = playGround.getGameResult()


        assertEquals(player1, winner)
        assertEquals(7,player1.points)
        assertEquals(1,player2.points)
    }

}
