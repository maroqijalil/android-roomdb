package my.maroqi.application.moviecatalogue.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import my.maroqi.application.moviecatalogue.ui.detail.DataDetailsViewModel
import my.maroqi.application.moviecatalogue.ui.main.list.CatalogueListViewModel
import my.maroqi.application.moviecatalogue.ui.favourite.list.FavouriteListViewModel

class ViewModelFactory(
    private val ctx: Context,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return when {
            modelClass.isAssignableFrom(CatalogueListViewModel::class.java) -> {
                CatalogueListViewModel(handle, ctx) as T
            }
            modelClass.isAssignableFrom(DataDetailsViewModel::class.java) -> {
                DataDetailsViewModel(handle) as T
            }
            modelClass.isAssignableFrom(FavouriteListViewModel::class.java) -> {
                FavouriteListViewModel(handle, ctx) as T
            }
            else -> throw IllegalArgumentException("Unknown View Model Class")
        }
    }
}