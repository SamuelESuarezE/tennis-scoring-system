package model

class Player(
    val name: String,
    private var score: Int = 0,
    var advantage: Boolean = false
) {
    fun winsAPoint() {
        score += if (score == 30) 10 else 15
    }

    fun getScore(): Int = score
}
