package models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StrikeTest {

    @Test
    fun `it should create new turn of type strike`() {
        val strike =
            Strike(pocketedCoins = CoinsCollection(1, 1), outThrownCoins = CoinsCollection(0, 0))

        assert(strike is Strike)
    }
}
