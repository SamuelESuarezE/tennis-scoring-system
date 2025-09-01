package model

class Player(
    var name: String,
) {
    private var score: Int = 0

    fun winsAPoint() {
        if (score == 40) return
        score += if (score == 30) 10 else 15
    }

    fun getScore(): Int = score

    fun resetScore() {
        score = 0
    }
}
