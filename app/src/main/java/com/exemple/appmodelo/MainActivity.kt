package com.exemple.appmodelo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.exemple.appmodelo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCardView() // Chamada do método
    }

// Método para o ouvinte de click do CardView 1
    private fun setupCardView(){
        binding.cardView1.setOnClickListener{
            Toast.makeText(baseContext, "Abrir outra tela", Toast.LENGTH_SHORT).show()
        }
    }
}