package my.maroqi.application.moviecatalogue.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import my.maroqi.application.moviecatalogue.ui.detail.DataDetailsViewModel
import my.maroqi.application.moviecatalogue.ui.main.list.CatalogueListViewModel

class ViewModelFactory(
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
                CatalogueListViewModel(handle) as T
            }
            modelClass.isAssignableFrom(DataDetailsViewModel::class.java) -> {
                DataDetailsViewModel(handle) as T
            }
            else -> throw IllegalArgumentException("Unknown View Model Class")
        }
    }
}