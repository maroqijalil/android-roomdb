package my.maroqi.application.moviecatalogue.utility

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import my.maroqi.application.moviecatalogue.data.source.local.DataIdlingResource
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun CoroutineScope.launchIdling (
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    DataIdlingResource.increment()
    val job = this.launch(context, start, block)
    job.invokeOnCompletion { DataIdlingResource.decrement() }
    return job
}