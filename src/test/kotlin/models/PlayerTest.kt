package models

class PlayerTest {

    @org.junit.jupiter.api.Test
    fun `it should create a player`() {
        val player = Player("Dnyaneshwar", CoinsCollection(0, 0), 1)

        assert(player is Player)
    }
}
