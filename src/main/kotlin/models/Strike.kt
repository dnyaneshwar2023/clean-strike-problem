package models

open class Strike(val pocketedCoins: CoinsCollection, val isStrikerFoul: Boolean, val outThrownCoins: CoinsCollection) {
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
