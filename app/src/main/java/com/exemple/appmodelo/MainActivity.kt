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

        * 1) app --> new --> Android Resource File
        * 2) name: nav_graph | resource type: Navigation --> OK

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
        * Entrando na unidade dinâmica e montando o layout (fragment_list e fragment_form)
        * Na activity_main (ou o container onde os fragments irão ficar)
        * E será criado o NavHostFragment (apenas jogar ele na ViewGroup do no container)
        * Será preciso ter um nav_graph para o NavHostFragment existir --> Basta pegar o nav_graph criado
        * Difina as constrains
        * O primeiro fragment que aparece será o da lista (pois foi definido assim no nav_graph - simbolo da casinha)

        * Fazendo com que os fragments consiga acessar o NavController e fazer a navegação entre eles

        * Dentro da parte lógica (FormFragment e ListFragment)

        * Para fazer a navegação dos fragments funcionarem vamos explorar as unidade lógica (FormFragment e ListFragment)
        * Ao construir o fragment é gerado a unidade dinâmica (layouts) e unidade lógica
        * Não precisamos colocar os fragments dentro do manifest para fazer a navegação entre telas
        * (como é feito com as activity usando intents)
        * Dentro da parte lógica (ListFragment e FormFragment) usaremos apenas o
        * OnCreatView para instanciar (criar) nossas coisas.
        * Portanto vamos limpar tudo e mantendo apenas o OnCreatView

        * Dentro do método OnCreatView

        * O nosso fragment retorna para a gente conseguir pegar a unidade dinâmica
        * Ele retorna nossa view a partir do inflater.
        * Para o nosso xml conseguir aparecer para gente, é preciso inflar ele.
        * Entao para ser definido que o listFragment vai receber a view, é preciso inflar a view e retornar ele dentro
        * do método OnCreatView
        * Dentro do fragment não é possível usar o findViewById sem ser dentro de um layout específico (dentro de uma view)
        * Jogar nossa objeto inflater em uma val view. E retornar ela mesma em return
        * Para se feito a navegação utilizando o Nav Controller, vamos referenciar nosso primeiro componente
        * dentro de uma val floatingAdd (vamos utilizar botao que fica no listFragment na unidade dinâmica)
        * vamos pegar a val view e colocar o fidViewById do tipo <FloatingActionButton> para o id floatingAdd
        * Agora temos este componente referênciado utilizando a nossa view
        * A partir disso podemos usar o metodo para click utilizando nossa val floatingAdd
        * para navegar para o proximo fragment por meio da ação criado no nosso nav_graph: action_listFragment_to_infoFragment
        * Para achar o nav controller e fazer esta navegação vamos usar o metodo: findNavController()
        * Este metodo vai verificar quem esta cuidando da navegação (que esta atrelado ao nav_graph)
        * Em seguida usamos o metodo: .navigate. E a partir dele iremos passar o id que indica nossa navgação
        * findNavController().navigate(R.id.action_listFragment_to_formFragment)

        * Este mesmo processo é usado para o formFragment, mas usando o button salvar

    *** Criando o Recycler View ***

        * Vamos usar recyclerView para fazer a montagem de lista dinâmica
        * Passos para criar o recyclerView:
            * Item: Aqui dentro criamos o card ou layout onde os itens serão inseridos
                    e dentro do item ciramos a classe modelo com as infos dos itens;
            * Adapter: Vai processar os dados de todos os itens e jogar no viewHolder;
            * viewHolder: Vai pegar o modelo que fazemos com o nosso item e dizer como irão aparecer.
                          A partir que o Adapter e a ViewHolder coseguir processar estes itens e mostrar pra gente,
                          vamos pegar e jogar no recyclerView
        * Primeiro vamos criar o card/layout que irá aparecer nossos itens que terá as infos.
        * Este layout irá mostrar todos os nossos itens;

        ** Criando card

        * Em res > layou: Criar um novo layout
        * (Layout Resource File --> Name: card_layout --> Root Element: cadrView)
        * Faça um layout para deixar os elementos de forma responsiva,
        * insira um LinearLayout ou ConstrainLayout dentro da ViewGroup CardView
        * Agora comece a criar o seu cardView

        * O próximo passo é criar a classe de modelo e fazer a listagem de tarefa
        * para começar a criar o adapter

        ** Criando Adapter (Para o Recycler View processar os dados)

        * Vamos criar em nosso pacote principal um pacote chamado adapter
        * 
*/