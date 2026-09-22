package com.example.p2_123140108

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.seconds

data class News(val id: Int, val title: String, val category: String)
data class DisplayNews(val id: Int, val formattedTitle: String, val category: String)

class NewsFeedViewSim {
    // StateFlow untuk berita yang sudah dibaca
    private val _readCount = MutableStateFlow(0)
    val readCount: StateFlow<Int> = _readCount

    // Flow data berita baru setiap 2 detik
    private fun getNews(): Flow<News> = flow {
        var id = 1
        val categories = listOf("Tech", "Lifestyle", "Food", "Sports", "Politics")

        while (true) {
            delay(2000)
            val randomCategory = categories.random()
            val news = News(id, "Berita Terkini $id", randomCategory)
            emit(news)
            id++
        }
    }

    // Coroutines untuk mengambil berita secara async
    suspend fun NewsDetail(newsId: Int): String {
        delay(1000)
        return "Berikut adalah detail lengkap untuk berita dengan ID-nya: $newsId ..."
    }

    // Fungsi utama untuk menjalankan berita
    suspend fun StartNewsFeed() = coroutineScope {
        launch {
            readCount.collect { count ->
                println("P2_Log: Berita yang sudah dibaca: $count")
            }
        }

        // Menjalankan berita aliran utama
        getNews()
            // Filter berita berdasarkan kategori tertentu
            .filter { news ->
                news.category == "Tech"
            }
            .map { news ->
                DisplayNews(
                    id = news.id,
                    formattedTitle = news.title.uppercase(),
                    category = news.category
                )
            }
            .collect { displayNews ->
                println("P2_Log: Berita baru dengan ID: ${displayNews.id}, Title: ${displayNews.formattedTitle}, Category: ${displayNews.category}")

                // Mengambil detail secara async tanpa memblokir thread
                println("P2_Log: Mengambil detail berita ID: ${displayNews.id}")
                val detail = NewsDetail(displayNews.id)
                println("P2_Log: Isi berita: $detail")

                // Menambahkan berita yang dibaca ke StateFlow
                _readCount.value++
            }
    }
}

class MainActivity : ComponentActivity() {
    private val scope = CoroutineScope(Dispatchers.Default + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Menjalankan simulator berita otomatis saat aplikasi dibuka
        scope.launch {
            val simulator = NewsFeedViewSim()

            // Atur agar simulasi berjalan dengan timeout 15 detik sesuai kodenya, tujuannya untu melihat simulasinya sebentar
            try {
                withTimeout(15.seconds) {
                    simulator.StartNewsFeed()
                }
            } catch (e: TimeoutCancellationException) {
                println("P2_Log: - Simulasi News Feed telah selesai -")
            }
        }

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "P2 News Feed Simulator Berjalan di Logcat!")
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}