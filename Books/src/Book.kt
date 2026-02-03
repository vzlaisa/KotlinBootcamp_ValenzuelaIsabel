import kotlin.random.Random

const val MAX_BOOKS_BORROWED = 5

open class Book(val title: String, val author: String, val year: Int, var pages: Int) {
    private var currentPage: Int = 0

    open fun readPage() {
        currentPage++
    }

    fun getTitleAuthor(): Pair<String, String> {
        return Pair(title, author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(books: Int): Boolean {
        return books < MAX_BOOKS_BORROWED
    }

    companion object {
        const val BASE_URL = "https://library/books/"
    }

    fun printUrl() {
        println("${BASE_URL}${title}.html")
    }
}

fun Book.weight() = pages * 1.5

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class EBook(title: String, author: String, year: Int, pages: Int, val format: String = "text"): Book(title, author, year, pages) {
    private var wordCount: Int = 0

    override fun readPage() {
        wordCount += 250
    }
}

class Puppy {
    fun playWithBook(book: Book) {
        val pagesTorn = Random.nextInt(1, 20)
        println(pagesTorn)
        book.tornPages(pagesTorn)
    }
}

fun main() {
    val book = Book("Kotlin", "Kotlin Inc", 2001, 100)

    val (title, author) = book.getTitleAuthor()
    val (_, _, year) = book.getTitleAuthorYear()

    println("Here is the book $title written by $author in $year.")

    val allBooks = setOf("Hamlet", "Macbeth", "Othello", "King Lear", "Romeo and Juliet")

    val library = mapOf("William Shakespeare" to allBooks)

    val hasHamnet = library.any{it -> it.value.contains("Hamlet")}
    println(hasHamnet)

    val moreBooks = mutableMapOf("Paula" to "Isabel Allende")
    moreBooks.getOrPut("Violeta") {
        "Isabel Allende"
    }

    println(moreBooks)

    val puppy = Puppy()
    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("Pages left: ${book.pages}")
        println("Book weight: ${book.weight()} grams")
        println("----------------------------")
    }
}


