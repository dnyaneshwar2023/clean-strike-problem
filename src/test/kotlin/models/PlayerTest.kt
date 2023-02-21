package models

class PlayerTest {

    @org.junit.jupiter.api.Test
    fun `it should create a player`() {
        val player = Player("Dnyaneshwar", 1,1)

        assert(player is Player)
    }
}
