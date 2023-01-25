package common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.w3c.dom.Document
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.ItemArrayLike
import org.w3c.dom.asList
import org.w3c.files.File
import org.w3c.files.FileReader
import kotlin.coroutines.suspendCoroutine

suspend fun Document.loadFileFromDisk(
    accept: String,
    scope: CoroutineScope,
    onLoaded: (List<String>) -> Unit,
) {
    val tempInput = (createElement("input") as HTMLInputElement).apply {
        type = "file"
        style.display = "none"
        this.accept = accept
        multiple = false
    }

    tempInput.onchange = { changeEvt ->
        val files = (changeEvt.target.asDynamic().files as ItemArrayLike<File>).asList()

        println(files)
        scope.launch {
            println("onLaunched")
            files.map { async { readFileAsText(it) } }
                .map { it.await() }
                .also {
                    println("onLoaded")
                    onLoaded(it)
                }
        }
        Unit
    }

    body!!.append(tempInput)
    tempInput.click()
    tempInput.remove()
}

suspend fun readFileAsText(file: File) = suspendCoroutine {
    val reader = FileReader()
    reader.onload = { loadEvt ->
        val content = loadEvt.target.asDynamic().result as String
        it.resumeWith(Result.success(content))
    }
    reader.readAsText(file, "UTF-8")
}