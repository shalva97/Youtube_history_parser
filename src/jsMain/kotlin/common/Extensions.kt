package common

import org.w3c.dom.Document
import org.w3c.dom.HTMLInputElement
import org.w3c.files.File
import org.w3c.files.FileReader

fun Document.loadFileFromDisk(
    accept: String,
    onLoaded: (String) -> Unit,
) {
    val tempInput = (createElement("input") as HTMLInputElement).apply {
        type = "file"
        style.display = "none"
        this.accept = accept
        multiple = false
    }

    tempInput.onchange = { changeEvt ->
        val file = changeEvt.target.asDynamic().files[0] as File

        val reader = FileReader()
        reader.onload = { loadEvt ->
            val content = loadEvt.target.asDynamic().result as String
            onLoaded(content)
        }
        reader.readAsText(file, "UTF-8")
    }

    body!!.append(tempInput)
    tempInput.click()
    tempInput.remove()
}