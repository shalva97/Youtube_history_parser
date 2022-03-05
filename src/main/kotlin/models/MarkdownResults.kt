package models

class MarkdownResults {

    private var results = StringBuilder()

    fun add(text: String) {
        results.append(text)
    }

    fun separator() {
        results.appendLine()
    }

    fun print() {
        println(results)
    }
}