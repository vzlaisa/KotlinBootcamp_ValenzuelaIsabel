enum class Directions() {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf<Directions>(Directions.START)

    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val west = { path.add(Directions.WEST) }
    val east = { path.add(Directions.EAST) }

    val end = {
        path.add(Directions.END);
        println("Game Over");
        println(path);
        path.clear();
        false
    }


    fun move(where: () -> Boolean): Boolean {
        return where.invoke()
    }

    fun makeMove(input: String?) {
        val stillPlaying = when (input) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }

        if (!stillPlaying) {
            println("Thanks for playing!")
        }
    }
}

fun main(args: Array<String>) {
    val game = Game()

    while (true) {
        print("Enter a direction: n/s/e/w: ")
        val input = readLine()
        game.makeMove(input)
    }
}