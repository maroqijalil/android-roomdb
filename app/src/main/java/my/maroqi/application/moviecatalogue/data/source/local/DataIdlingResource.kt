package my.maroqi.application.moviecatalogue.data.source.local

object DataIdlingResource {

    private const val RESOURCE = "GLOBAL"
    val dataIdlingResource = CustomCountingIdlingResource(RESOURCE)

    fun increment() {
        dataIdlingResource.increment()
    }

    fun decrement() {
        dataIdlingResource.decrement()
    }
}