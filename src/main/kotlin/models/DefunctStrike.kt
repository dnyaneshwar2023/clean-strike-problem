package models

class DefunctStrike(outThrownCoins: CoinsCollection) :
    Strike(outThrownCoins = outThrownCoins) {

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
