import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.singleWindowApplication
import java.awt.Desktop

fun main() {
    var text by mutableStateOf("Hello, World!")

    try {
        Desktop.getDesktop().setOpenURIHandler { event ->
            text = "Open URI: " + event.uri
        }
    } catch (e: UnsupportedOperationException) {
        println("setOpenURIHandler is unsupported")
    }

    singleWindowApplication {
        MaterialTheme {
            Text(text)
        }
    }
}