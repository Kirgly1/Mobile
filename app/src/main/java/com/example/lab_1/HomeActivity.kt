package com.example.lab_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        chatRecyclerView.layoutManager = LinearLayoutManager(this)

        val chatList = listOf(
            Chat("Дима", "Привет!", "12:01", R.drawable.profile_image_1),
            Chat("Сергей", "Как дела?", "12:05", R.drawable.profile_image_2),
            Chat("Саша", "Когда встретимся?", "12:10", R.drawable.profile_image_3),
            Chat("Иван", "Че как", "12:40", R.drawable.profile_image_4),
            Chat("Даниил", "Сегодня в зал ходил?", "19:23", R.drawable.profile_image_5),
            Chat("Георгий", "Привет", "11:15", R.drawable.profile_image_6),
            Chat("Анатолий", "Смотри что сделал", "02:30", R.drawable.profile_image_7),
            Chat("Юля", "Привет", "15:32", R.drawable.profile_image_8),
            Chat("Яна", "Как тебе артик", "18:09", R.drawable.profile_image_9),
            Chat("Екатерина", "Как дела", "21:00", R.drawable.profile_image_10),
            Chat("Денис", "В ноябре приедешь?", "20:01", R.drawable.profile_image_11),
            Chat("Андрей", "Сегодня свободен?", "08:35", R.drawable.profile_image_12)

        )
        chatAdapter = ChatAdapter(chatList)
        chatRecyclerView.adapter = chatAdapter
    }
}
