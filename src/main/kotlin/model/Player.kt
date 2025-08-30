package model

class Player(
    private var score: Int = 0,
    var advantage: Boolean = false,
    var won: Boolean = false
) {
    fun winsAPoint() {
        if (score == 40) return
        score += if (score == 30) 10 else 15
    }

    fun getScore(): Int = score

    fun resetScore() {
        score = 0
    }
}
