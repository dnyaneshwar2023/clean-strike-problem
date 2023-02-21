package models

class DefunctStrike(pocketedCoins: CoinsCollection, isStrikerFoul: Boolean, outThrownCoins: CoinsCollection) :
    Strike(pocketedCoins, isStrikerFoul, outThrownCoins) {

    override fun calculatePoints(): Int {
        return -2
    }

    override fun calculateEarnedCoins(): CoinsCollection {
        return CoinsCollection(0, 0)
    }

    override fun calculateReturnCoins(): CoinsCollection {
        return CoinsCollection(0, 0)
    }
}
