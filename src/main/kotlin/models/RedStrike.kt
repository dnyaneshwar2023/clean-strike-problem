package models

class RedStrike(pocketedCoins: CoinsCollection, isStrikerFoul: Boolean, outThrownCoins: CoinsCollection) :
    Strike(pocketedCoins, isStrikerFoul, outThrownCoins) {

    override fun calculatePoints(): Int {
        return 3
    }

    override fun calculateEarnedCoins(): CoinsCollection {
        return CoinsCollection(pocketedCoins.redCoins, 0)
    }

    override fun calculateReturnCoins(): CoinsCollection {
        return CoinsCollection(0, pocketedCoins.blackCoins)
    }
}
