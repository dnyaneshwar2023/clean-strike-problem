package models

import exceptions.InsufficientCoinsException

class PlayGround(val firstPlayer: Player, val secondPlayer: Player, val coins: CoinsCollection) {

    fun addCoins(coinsToAdd: CoinsCollection) {
        coins.addCoins(coinsToAdd)
    }

    fun performTurn(player: Player, strike: Strike) {
        validateTurn(strike)

        val coinsEarned = strike.calculateEarnedCoins()
        player.coins.addCoins(coinsEarned)

        player.points += strike.calculatePoints()

        val returnCoins = strike.calculateReturnCoins()
        coins.addCoins(returnCoins)

    }

    private fun validateTurn(strike: Strike) {
        if (checkBlackCoinsOverflow(strike) || checkRedCoinsOverflow(strike)) {
            throw InsufficientCoinsException("Invalid turn, Not insufficient coins in board to pocket")
        }
    }

    private fun checkRedCoinsOverflow(strike: Strike): Boolean {
        return coins.redCoins < strike.pocketedCoins.redCoins + strike.outThrownCoins.redCoins
    }

    private fun checkBlackCoinsOverflow(strike: Strike): Boolean {
        return coins.blackCoins < strike.pocketedCoins.blackCoins + strike.outThrownCoins.blackCoins
    }
}
