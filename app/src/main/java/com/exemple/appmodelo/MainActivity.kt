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
    *** Usando o ViewBinding ***
        - Instalando

    *** Criando o Fragments ***
        * 1) Gerar gráfico de navegação
        * 2) Colocar gráfico de navegação em relação ao container (NavHostFragment)
        * 3) Acessar navController para fazer navegação

        * app --> new --> Android Resource File
        * name: nav_graph | resource type: Navigation --> OK

        * Adicionando novos destinos ao programa (add distination)
        * Primeiro Fragment - Create new destination --> Fragment Blank --> Name: listFragment --> Finish
        * Segundo Fragment - Create new destination --> Fragment Blank --> Name: formFragment --> Finish
        * Ligar os dois fragments e indicar as ações
        * listFragment navega para o formFragment
        * FormFragment navega para o listFragment (após salvar uma tarefa)
        * Para não ser criado uma nova instancia de listFragment, depois de salvar tarefa no formFragment
        * Selecionar action_formFragment_toListFragment
        * Vamos usar o comportamento: Pop Behavior --> popUpTo: listFragment (Ao voltar para o list o form será morto)
        * Para ele criar uma nova tela de listFragment e carregar a lista novamente (criando do zero)
        * (matando os processos list e form anteriores e criando um novo list)
        * popUpToInclusive: True
        * Entrando na unidade dinâmica e montando o layout (frafment_list e fragment_form)
        * Na activity_main (ou o container onde os fragments irão ficar)
        * E será criado o NavHostFragment (apenas jogar ele na ViewGroup do no container)
        * Será preciso ter um nav_graph para o NavHostFragment existir --> Basta pegar o nav_graph criado
        * Difina as constrains
        * O primeiro fragment que aparece será o da lista (pois foi definido assim no nav_graph - simbolo da casinha)

        * Fazendo com que os fragments consiga acessar o NavController e fazer a navegação entre eles
*/