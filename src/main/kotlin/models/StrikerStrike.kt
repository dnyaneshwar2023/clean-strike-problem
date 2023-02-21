package models

class StrikerStrike(pocketedCoins: CoinsCollection) :
    Strike(pocketedCoins = pocketedCoins) {

    override fun calculatePoints(): Int {
        return -1
    }

    override fun calculateEarnedCoins(): CoinsCollection {
        return CoinsCollection(0, 0)
    }

    override fun calculateReturnCoins(): CoinsCollection {
        return CoinsCollection(pocketedCoins.redCoins, pocketedCoins.blackCoins)
    }
}
