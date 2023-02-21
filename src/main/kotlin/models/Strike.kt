package models

open class Strike(
    val pocketedCoins: CoinsCollection = CoinsCollection(0, 0),
    val outThrownCoins: CoinsCollection = CoinsCollection(0, 0)
) {
    open fun calculatePoints(): Int {
        return 1
    }

    open fun calculateEarnedCoins(): CoinsCollection {
        return CoinsCollection(0, 0)
    }

    open fun calculateReturnCoins(): CoinsCollection {
        return CoinsCollection(0, 0)
    }
}
