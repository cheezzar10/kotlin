package learn.atomic.advanced

class Wrapper {
    private val valueDelegate = lazy(this::initValue)
    private val value: String by valueDelegate

    private fun initValue(): String = "${System.currentTimeMillis()}"

    override fun toString(): String {
        val v = value

        return if (valueDelegate.isInitialized()) {
            String.format("%s", v)
        } else {
            ""
        }
    }
}

fun main() {
    val wrapper = Wrapper()
    println(wrapper)
}