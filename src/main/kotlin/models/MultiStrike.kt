package models

class MultiStrike(pocketedCoins: CoinsCollection, isStrikerFoul: Boolean, outThrownCoins: CoinsCollection) :
    Strike(pocketedCoins, isStrikerFoul, outThrownCoins) {

    override fun calculatePoints(): Int {
        return 2
    }

    override fun calculateEarnedCoins(): CoinsCollection {
        return CoinsCollection(pocketedCoins.redCoins, pocketedCoins.blackCoins)

    }

    override fun calculateReturnCoins(): CoinsCollection {
        return CoinsCollection(0, 0)
    }
}
