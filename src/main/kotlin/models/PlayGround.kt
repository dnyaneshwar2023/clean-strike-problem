package models

class PlayGround(val firstPlayer: Player, val secondPlayer: Player, val coins: CoinsCollection) {

    fun addCoins(coinsToAdd: CoinsCollection) {
        coins.addCoins(coinsToAdd)
    }

    fun performTurn(player: Player, strike: Strike) {

        val coinsEarned = strike.calculateEarnedCoins()

        player.coins.addCoins(coinsEarned)
        player.points += strike.calculatePoints()

        val returnCoins = strike.calculateReturnCoins()
        coins.addCoins(returnCoins)

    }
}
