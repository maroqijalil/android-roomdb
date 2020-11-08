package my.maroqi.application.moviecatalogue.utility

import android.os.Build
import androidx.annotation.RequiresApi

class ListCaster {
    companion object {
        fun getStringList(listString: ArrayList<String>?): String {
            var str = ""

            listString?.forEachIndexed { index, it ->
                str += if (index < listString.size - 1)
                    "$it, "
                else
                    it
            }

            return str
        }

        @RequiresApi(Build.VERSION_CODES.N)
        fun getStringListFromMap(listString: Map<String, String>?): String {
            var str = ""

            if (listString != null) {
                var index = 0

                listString.forEach { (_, v) ->
                    str += if (index < listString.size - 1)
                        "$v, "
                    else
                        v

                    index++
                }
            }

            return str
        }
    }
}