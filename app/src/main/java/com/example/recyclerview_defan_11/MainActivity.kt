package com.example.recyclerview_defan_11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.superman,
                "Superman",
                "Superman, adalah pahlawan super fiksi yang muncul dalam buku komik Amerika yang diterbitkan oleh DC Comics. Superman secara luas telah dianggap sebagai ikon budaya yang melambangkan kekuatan budaya Amerika Serikat."
            ),
            Superhero(
                R.drawable.batman,
                "Batman",
                "Batman adalah tokoh fiksi pahlawan super yang diciptakan oleh seniman Bob Kane dan penulis Bill Finger dan diterbitkan oleh DC Comics. Tokoh ini pertama muncul di Detective Comics #27. Identitas asli Batman adalah Bruce Wayne, seorang pengusaha yang kaya raya."
            ),
            Superhero(
                R.drawable.wonder,
                "Wonder Woman",
                "Wonder Woman adalah karakter perempuan superhero fiktif yang muncul di buku komik Amerika Serikat yang diterbitkan oleh DC Comics. Karakter ini adalah putri pejuang dari bangsa Amazon dan dikenal di tanah airnya, Themyscira, sebagai Putri Diana dari Themyscira."
            ),
            Superhero(
                R.drawable.aquaman,
                "Aquaman",
                "Aquaman adalah pahlawan super dalam buku komik Amerika yang diterbitkan oleh DC Comics. Dibuat oleh Paul Norris dan Mort Weisinger, karakter ini memulai debutnya di More Fun Comics #73. Awalnya adalah fitur cadangan dalam judul antologi DC, Aquaman kemudian membintangi beberapa volume seri buku komik solo."
            ),
            Superhero(
                R.drawable.flash,
                "Flash",
                "The Flash (Bartholomew Henry Allen) adalah pahlawan super yang muncul dalam komik yang diterbitkan oleh DC Comics. Karakter ini pertama kali muncul di Showcase #4 (Oktober 1956), yang diciptakan oleh penulis Robert Kanigher dan pemensil Carmine Infantino."
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this, superheroList) {
            val intent = Intent (this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}