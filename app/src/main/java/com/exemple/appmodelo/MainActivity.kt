package com.exemple.appmodelo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.exemple.appmodelo.databinding.ActivityMainBinding
import com.exemple.appmodelo.databinding.ActivityTelaCardView1Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        /*
            * Chamada do método para fazer transição de tela
            * Ir da MainActivity para Tela do CardView
        */
        irTelaCardView1()
        irTelaCardView2()
        irTelaCardView3()
        irTelaCardView4()
        irTelaCardView5()

        setContentView(binding.root)
    }

// Método para mudar de Activity
    // CardView1
    private fun irTelaCardView1(){
        binding.cardView1.setOnClickListener{
            val telaCardView1 = Intent(this, TelaCardView1::class.java)
            startActivity(telaCardView1)
        }
    }

    // CardView2
    private fun irTelaCardView2(){
        binding.cardView2.setOnClickListener{
            // Intent - transição de Activity
            val telaCardView2 = Intent(this, TelaCardView2::class.java)
            startActivity(telaCardView2)
        }
    }

    // CardView3
    private fun irTelaCardView3(){
        binding.cardView3.setOnClickListener{
            val telaCardView3 = Intent(this, TelaCardView3::class.java)
            startActivity(telaCardView3)
        }
    }

    // CardView4
    private fun irTelaCardView4(){
        binding.cardView4.setOnClickListener{
            val telaCardView4 = Intent(this, TelaCardView4::class.java)
            startActivity(telaCardView4)
        }
    }

    // CardView5
    private fun irTelaCardView5(){
        binding.cardView5.setOnClickListener{
            val telaCardView5 = Intent(this, TelaCardView5::class.java)
            startActivity(telaCardView5)
        }
    }
}


/*
    * Usando o ViewBinding
        - Instalando

    * Criando o Fragments
        * 1) Gerar gráfico de navegação
        * 2) Colocar gráfico de navegação em relação ao container (NavHostFragment)
        * 3) Acessar navController para fazer navegação

        * app --> new --> Android Resource File
        * name: nav_graph | resource type: Navigation --> OK

        * Adicionando novos destinos ao programa (add distination)
        * Create new destination --> Fragment Blank --> Name: ListFragment --> Finish
*/