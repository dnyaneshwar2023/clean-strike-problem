package models

open class Strike(val pocketedCoins: CoinsCollection, val isStrikerFoul: Boolean, val outThrownCoins: CoinsCollection) {
    fun calculatePoints(): Int {
        return 1
    }

    fun calculateEarnedCoins(): Int {
        return 1
    }

    fun calculateReturnCoins(): Int {
        return 1
    }

}
