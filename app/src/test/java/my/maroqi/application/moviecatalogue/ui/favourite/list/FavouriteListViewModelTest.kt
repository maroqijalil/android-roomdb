package my.maroqi.application.moviecatalogue.ui.favourite.list

import android.app.Application
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import androidx.paging.PagedList
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import my.maroqi.application.moviecatalogue.data.FavouriteRepository
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.source.local.db.DataRoomDatabase
import my.maroqi.application.moviecatalogue.ui.data.DataLists
import my.maroqi.application.moviecatalogue.utility.getOrAwaitValue
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class FavouriteListViewModelTest  {

    private lateinit var viewModel: FavouriteListViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var favouriteRepository: FavouriteRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieItem>>

    @Mock
    private lateinit var pagedList: PagedList<MovieItem>

    @Mock
    private lateinit var handle: SavedStateHandle

    @Mock
    private lateinit var context: Context

    private lateinit var db: DataRoomDatabase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
//        val context = InstrumentationRegistry.getInstrumentation().context

//        Mockito.`when`(context.applicationContext).thenReturn(context)

        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().context, DataRoomDatabase::class.java)
            .build()
        viewModel = FavouriteListViewModel(handle, context)
    }

    @After
    @Throws(IOException::class)
    fun close() {
        db.close()
    }

    @Test
    fun getCourses() {
        val movieList = DataLists.getMovieListData()
        val pagedList = mockPagedList(movieList)
        addMovieListToDb(movieList)

//        val courseEntities = viewModel.getAllMovie().value
//        Mockito.verify(favouriteRepository).getAllMoviePaged()
//        Assert.assertNotNull(courseEntities)
//        Assert.assertEquals(10, courseEntities?.size)
////
//        viewModel.getAllMovie().observeForever(observer)
//        Mockito.verify(observer).onChanged(dummyCourses)

        handle = SavedStateHandle()
        viewModel = FavouriteListViewModel(handle, context)

        Assert.assertEquals(viewModel.getAllMovie().getOrAwaitValue(), pagedList)

        delMovieListToDb(movieList)
    }

    fun <T> mockPagedList(list: List<T>): PagedList<T> {
        val pagedList = Mockito.mock(PagedList::class.java) as PagedList<T>
        Mockito.`when`(pagedList.get(ArgumentMatchers.anyInt())).then { invocation ->
            val index = invocation.arguments.first() as Int
            list[index]
        }
        Mockito.`when`(pagedList.size).thenReturn(list.size)
        return pagedList
    }

    fun addMovieListToDb(list: List<MovieItem>) {
        list.forEach{
            db.movieDao().insert(it)
        }
    }

    fun delMovieListToDb(list: List<MovieItem>) {
        list.forEach{
            db.movieDao().delete(it.title!!)
        }
    }
}