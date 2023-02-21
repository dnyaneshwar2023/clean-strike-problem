package models

class CoinsCollection(var redCoins: Int, var blackCoins: Int) {
    fun addCoins(otherCoinCollection: CoinsCollection) {
        redCoins += otherCoinCollection.redCoins
        blackCoins += otherCoinCollection.blackCoins
    }
}
