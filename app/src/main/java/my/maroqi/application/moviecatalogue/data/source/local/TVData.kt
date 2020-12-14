package my.maroqi.application.moviecatalogue.data.source.local

import my.maroqi.application.moviecatalogue.R

object TVData {

    val titles: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add("The Arrow")
            array.add("Dragon Ball")
            array.add("Fairy Tail")
            array.add("The Flash")
            array.add("Gotham")
            array.add("Iron Fist")
            array.add("Naruto Shipuden")
            array.add("Supergirl")
            array.add("The Simpsons")
            array.add("The Walking Dead")

            return array
        }

    val years: ArrayList<Int>
        get() {
            val array = arrayListOf<Int>()

            array.add(2012)
            array.add(1986)
            array.add(2017)
            array.add(2014)
            array.add(2014)
            array.add(2017)
            array.add(2007)
            array.add(2015)
            array.add(1989)
            array.add(2010)

            return array
        }

    val drawables: ArrayList<Int> = arrayListOf(
        R.drawable.tv_poster_arrow,
        R.drawable.tv_poster_dragon_ball,
        R.drawable.tv_poster_fairytail,
        R.drawable.tv_poster_flash,
        R.drawable.tv_poster_gotham,
        R.drawable.tv_poster_iron_fist,
        R.drawable.tv_poster_naruto_shipudden,
        R.drawable.tv_poster_supergirl,
        R.drawable.tv_poster_the_simpson,
        R.drawable.tv_poster_the_walking_dead
    )

    val releaseDate: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add("2012")
            array.add("1986")
            array.add("2017")
            array.add("2014")
            array.add("2014")
            array.add("2017")
            array.add("2007")
            array.add("2015")
            array.add("1989")
            array.add("2010")

            return array
        }

    val genres: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add("Kejahatan, Drama, Misteri, Aksi & Petualangan")
            array.add("Komedi, Sci-fi & Fantasy, Animasi, Aksi & Petualangan")
            array.add("Aksi, Petualangan, Komedi, Fantasi, Animasi")
            array.add("Drama, Sci-fi & Fantasy")
            array.add("Drama, Fantasi, Kejahatan")
            array.add("Aksi & Petualangan, Drama, Sci-fi & Fantasy")
            array.add("Animasi, Komedi, Drama")
            array.add("Aksi, Petualangan, Drama, Cerita Fiksi")
            array.add("Animasi, Komedi, Keluarga, Drama")
            array.add("Aksi & Petualangan, Drama, Sci-fi & Fantasy")

            return array
        }

    val duration: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add("42 " + "menit")
            array.add("25 " + "menit")
            array.add("1" + " jam " + "25 " + "menit")
            array.add("44 " + "menit")
            array.add("43 " + "menit")
            array.add("55 " + "menit")
            array.add("25 " + "menit")
            array.add("42 " + "menit")
            array.add("22 " + "menit")
            array.add("42 " + "menit")

            return array
        }

    val userScore: ArrayList<Int>
        get() {
            val array = arrayListOf<Int>()

            array.add(65)
            array.add(80)
            array.add(65)
            array.add(75)
            array.add(56)
            array.add(64)
            array.add(87)
            array.add(78)
            array.add(83)
            array.add(79)

            return array
        }

    val shortDesc: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add(
                "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow."
            )
            array.add(
                "Dahulu kala di pegunungan, seorang master pertempuran yang dikenal sebagai Gohan menemukan seorang bocah aneh yang ia beri nama Goku. Gohan membesarkannya dan melatih Goku dalam seni bela diri sampai dia mati. Bocah muda dan sangat kuat itu sendirian, tetapi mudah dikelola. Kemudian suatu hari, Goku bertemu dengan seorang gadis remaja bernama Bulma, yang pencariannya untuk bola naga membawanya ke rumah Goku. Bersama-sama, mereka berangkat untuk menemukan ketujuh bola naga dalam sebuah petualangan yang akan mengubah hidup Goku selamanya. Lihat bagaimana Goku bertemu teman-teman seumur hidupnya Bulma, Yamcha, Krillin, Master Roshi dan banyak lagi."
            )
            array.add(
                "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction."
            )
            array.add(
                "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash."
            )
            array.add(
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?"
            )
            array.add(
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny."
            )
            array.add(
                "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki."
            )
            array.add(
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism."
            )
            array.add(
                "Bertempat di Springfield, kota rata-rata di Amerika, pertunjukan ini berfokus pada kejenakaan dan petualangan sehari-hari keluarga Simpson; Homer, Marge, Bart, Lisa dan Maggie, serta ribuan pemain virtual. Sejak awal, serial ini telah menjadi ikon budaya pop, menarik ratusan selebriti menjadi bintang tamu. Acara ini juga menjadi terkenal karena satirnya yang tak kenal takut terhadap kehidupan politik, media, dan Amerika secara umum."
            )
            array.add(
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way."
            )

            return array
        }

    val teams: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add("Greg Berlanti, Marc Guggenheim, Andrew Kreisberg")
            array.add("Akira Toriyama")
            array.add("Hiro Mashima")
            array.add("Greg Berlanti, Geoff Johns, Andrew Kreisberg")
            array.add("Bruno Heller")
            array.add("Scott Buck")
            array.add("Masashi Kishimoto")
            array.add("Greg Berlanti, Ali Adler, Andrew Kreisberg")
            array.add("Matt Groening")
            array.add("Frank Darabont")

            return array
        }

    val actors: ArrayList<String>
        get() {
            val array = arrayListOf<String>()

            array.add("Stephen Amell, David Ramsey, Katie Cassidy")
            array.add("Masako Nozawa, Mayumi Tanaka, Hiromi Tsuru")
            array.add("Makoto Furukawa, Wataru Hatano, Aya Hirano")
            array.add("Grant Gustin, Candice Patton, Carlos Valdes")
            array.add("Ben McKenzie, Donal Logue, David Mazouz")
            array.add("Finn Jones, Jessica Henwick, Jessica Stroup")
            array.add("Kazuhiko Inoue, Jouji Nakata, Akira Ishida")
            array.add("Melissa Benoist, Chyler Leigh, David Harewood")
            array.add("Dan Castellaneta, Julie Kavner, Nancy Cartwright")
            array.add("Norman Reedus, Danai Gurira, Andrew Lincoln")

            return array
        }
}