package my.maroqi.application.moviecatalogue.utility

interface DBHelper {
    fun insertFavMovie(item: MovieResource)
    fun insertFavTV(item: TVResource)
    fun showAlert(title: String, msg: String, item: Any, type: ListItemType, position: Int)
}