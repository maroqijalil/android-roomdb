package my.maroqi.application.moviecatalogue.data

interface RepositorySource<T> {
    fun getListData(): ArrayList<T>
    fun getData(index: Int): T
}