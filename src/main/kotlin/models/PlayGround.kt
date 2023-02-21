package models

import exceptions.InsufficientCoinsException

class PlayGround(private val firstPlayer: Player, private val secondPlayer: Player, val coins: CoinsCollection) {
    private var winner: Player? = null

    fun getGameResult(): Player? {
        return winner
    }

    fun performTurn(player: Player, strike: Strike) {
        validateTurn(strike)

        val coinsEarned = strike.calculateEarnedCoins()
        player.coins.addCoins(coinsEarned)

        player.points += strike.calculatePoints()

        val returnCoins = strike.calculateReturnCoins()
        coins.addCoins(returnCoins)

        updateResult()
    }

    private fun updateResult() {
        winner = getWinner()
    }

    private fun getWinner(): Player? {
        return when {
            firstPlayer.points >= 5 && firstPlayer.points > secondPlayer.points + 3 -> {
                firstPlayer
            }

            secondPlayer.points >= 5 && secondPlayer.points > firstPlayer.points + 3 -> {
                secondPlayer
            }

            else -> null
        }
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
