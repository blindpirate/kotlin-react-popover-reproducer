import bootstrap.BootstrapDropdownButton
import kotlinx.browser.document
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.render
import kotlin.js.Date

external interface Video {
    val id: Int
    val title: String
    val speaker: String
    val videoUrl: String
}

data class KotlinVideo(
    override val id: Int,
    override val title: String,
    override val speaker: String,
    override val videoUrl: String
) : Video

fun currentTimeMillis(): Long = Date().getTime().toLong()

data class Live(
    val startEpochMs: Long,
    val endEpochMs: Long
) {
//    fun isLive() = currentTimeMillis() in start..end
}

private fun Live.isLive(): Boolean {
    /*
    LivestreamIndicators.kt?c769:88 Uncaught TypeError: tmp$.lessThanOrEqual is not a function
at LivestreamIndicators.isLive_0 (LivestreamIndicators.kt?c769:88)
at eval (LivestreamIndicators.kt?c769:100)
at absoluteDiv (Utils.kt?ecb7:103)
at LivestreamIndicators.render_ss14n$ (LivestreamIndicators.kt?c769:92)
at eval (kotlin-react.js?b73f:592)
at buildElements (kotlin-react.js?b73f:452)
at buildElements_0 (kotlin-react.js?b73f:469)
at LivestreamIndicators.RComponent.render (kotlin-react.js?b73f:597)
at finishClassComponent (react-dom.development.js?f6e0:17485)
at updateClassComponent (react-dom.development.js?f6e0:17435)
     */
    val now = currentTimeMillis()
    val start = startEpochMs
    val end = endEpochMs
    return js("now>=start && now<=end")
}


fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }
}

class App: RComponent<Props, State>() {
    override fun RBuilder.render() {
        BootstrapDropdownButton {
            attrs.id = "locale-selection"
            attrs.title = "ClickMe"
            BootstrapDropdownItem {
                +"123"
            }
        }
    }
}
