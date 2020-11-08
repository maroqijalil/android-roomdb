package my.maroqi.application.moviecatalogue.data.source.local

import my.maroqi.application.moviecatalogue.R

object MovieData {

    val titles: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add("A Star is Born")
            array.add("Alita: Battle Angel")
            array.add("Aquaman")
            array.add("Bohemian Rhapsody")
            array.add("Cold Pursuit")
            array.add("Creed II")
            array.add("Glass")
            array.add("How to Train your Dragon")
            array.add("Avengers: Infinity War")
            array.add("Robin Hood")

            return array
        }

    val years: ArrayList<Int>
        get() {
            val array = arrayListOf<Int>()

            array.add(2018)
            array.add(2019)
            array.add(2018)
            array.add(2018)
            array.add(2019)
            array.add(2018)
            array.add(2019)
            array.add(2019)
            array.add(2018)
            array.add(2018)

            return array
        }

    val drawables: ArrayList<Int> = arrayListOf(
        R.drawable.movie_poster_a_star_is_born,
        R.drawable.movie_poster_alita,
        R.drawable.movie_poster_aquaman,
        R.drawable.movie_poster_bohemian,
        R.drawable.movie_poster_cold_persuit,
        R.drawable.movie_poster_creed,
        R.drawable.movie_poster_glass,
        R.drawable.movie_poster_how_to_train,
        R.drawable.movie_poster_infinity_war,
        R.drawable.movie_poster_robin_hood
    )

    val releaseDate: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add("05/10/2018")
            array.add("14/02/2019")
            array.add("21/12/2018")
            array.add("02/11/2018")
            array.add("08/02/2019")
            array.add("25/11/2018")
            array.add("18/01/2019")
            array.add("22/02/2019")
            array.add("27/04/2018")
            array.add("21/11/2018")

            return array
        }

    val country: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add("US")
            array.add("US")
            array.add("US")
            array.add("US")
            array.add("US")
            array.add("US")
            array.add("US")
            array.add("US")
            array.add("US")
            array.add("US")

            return array
        }

    val genres: ArrayList<ArrayList<String>>
        get() {
            val array = arrayListOf<ArrayList<String>>()

            array.add(arrayListOf("Drama", "Percintaan", "Musik"))
            array.add(arrayListOf("Aksi", "Cerita fiksi", "Petualangan"))
            array.add(arrayListOf("Aksi", "Fantasi", "Petualangan"))
            array.add(arrayListOf("Drama", "Musik"))
            array.add(arrayListOf("Aksi", "Kejahatan", "Cerita seru"))
            array.add(arrayListOf("Drama"))
            array.add(arrayListOf("Drama", "Cerita seru", "Cerita fiksi"))
            array.add(arrayListOf("Animasi", "Keluarga", "Petualangan"))
            array.add(arrayListOf("Aksi", "Cerita fiksi", "Petualangan"))
            array.add(arrayListOf("Aksi", "Cerita seru", "Petualangan"))

            return array
        }

    val duration: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add("2" + " jam " + "16 " + "menit")
            array.add("2" + " jam " + "2 " + "menit")
            array.add("2" + " jam " + "24 " + "menit")
            array.add("2" + " jam " + "15 " + "menit")
            array.add("1" + " jam " + "59 " + "menit")
            array.add("2" + " jam " + "13 " + "menit")
            array.add("2" + " jam " + "9 " + "menit")
            array.add("1" + " jam " + "44 " + "menit")
            array.add("2" + " jam " + "29 " + "menit")
            array.add("2" + " jam " + "29 " + "menit")

            return array
        }

    val userScore: ArrayList<Int>
        get() {
            val array = arrayListOf<Int>()

            array.add(75)
            array.add(71)
            array.add(69)
            array.add(80)
            array.add(56)
            array.add(74)
            array.add(66)
            array.add(78)
            array.add(83)
            array.add(59)

            return array
        }

    val shortDesc: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add(
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini."
            )
            array.add(
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa."
            )
            array.add(
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
            )
            array.add(
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
            )
            array.add(
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."
            )
            array.add(
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed."
            )
            array.add(
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
            )
            array.add(
                "Ketika Hiccup memenuhi mimpinya untuk menciptakan utopia naga yang damai, penemuan Toothless 'dari pasangan yang tak teruji dan sukar ditangkap membuat Night Fury menjauh. Ketika bahaya meningkat di rumah dan pemerintahan Hiccup sebagai kepala desa diuji, baik naga dan pengendara harus membuat keputusan yang mustahil untuk menyelamatkan jenis mereka."
            )
            array.add(
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti."
            )
            array.add(
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."
            )

            return array
        }

    val teams: ArrayList<Map<String, String>>
        get() {
            val array = arrayListOf<Map<String, String>>()

            array.add(mapOf("Sutradara" to "Bradley Cooper", "Skenario" to "Will Fetters", "Cerita" to "William A. Wellman"))
            array.add(mapOf("Sutradara" to "Robert Rodriguez", "Skenario" to "-", "Cerita" to "-"))
            array.add(mapOf("Sutradara" to "James Wan", "Skenario" to "Will Beall", "Cerita" to "Geoff Johns"))
            array.add(mapOf("Sutradara" to "Bryan Singer", "Skenario" to "Anthony McCarten", "Cerita" to "Peter Morgan"))
            array.add(mapOf("Sutradara" to "Hans Petter Moland", "Skenario" to "-", "Cerita" to "-"))
            array.add(mapOf("Sutradara" to "Ryan Coogler", "Skenario" to "-", "Cerita" to "-"))
            array.add(mapOf("Sutradara" to "M. Night Shyamalan", "Skenario" to "-", "Cerita" to "-"))
            array.add(mapOf("Sutradara" to "Dean DeBlois", "Skenario" to "-", "Cerita" to "-"))
            array.add(mapOf("Sutradara" to "Joe Russo", "Skenario" to "-", "Cerita" to "-"))
            array.add(mapOf("Sutradara" to "Otto Bathurst", "Skenario" to "-", "Cerita" to "Ben Chandler"))

            return array
        }

    val actors: ArrayList<ArrayList<String>>
        get() {
            val array = arrayListOf<ArrayList<String>>()

            array.add(arrayListOf("Bradley Cooper", "Lady Gaga", "Sam Elliott"))
            array.add(arrayListOf("Rosa Salazar", "Christoph Waltz", "Jennifer Connelly"))
            array.add(arrayListOf("Jason Momoa", "Amber Heard", "Willem Dafoe"))
            array.add(arrayListOf("Rami Malek", "Gwilym Lee", "Ben Hardy"))
            array.add(arrayListOf("Liam Neeson", "Laura Dern", "Emmy Rossum"))
            array.add(arrayListOf("Michael B. Jordan", "Sylvester Stallone", "Tessa Thompson"))
            array.add(arrayListOf("James McAvoy", "Bruce Willis", "Anya Taylor-Joy"))
            array.add(arrayListOf("Jay Baruchel", "America Ferrera", "Cate Blanchett"))
            array.add(arrayListOf("Robert Downey Jr.", "Chris Hemsworth", "Chris Evans"))
            array.add(arrayListOf("Taron Egerton", "Jamie Foxx", "Ben Mendelsohn"))

            return array
        }
}