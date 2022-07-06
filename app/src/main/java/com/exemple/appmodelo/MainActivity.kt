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
    private fun irTelaCardView1() {
        binding.cardView1.setOnClickListener {
            val telaCardView1 = Intent(this, TelaCardView1::class.java)
            startActivity(telaCardView1)
        }
    }

    // CardView2
    private fun irTelaCardView2() {
        binding.cardView2.setOnClickListener {
            // Intent - transição de Activity
            val telaCardView2 = Intent(this, TelaCardView2::class.java)
            startActivity(telaCardView2)
        }
    }

    // CardView3
    private fun irTelaCardView3() {
        binding.cardView3.setOnClickListener {
            val telaCardView3 = Intent(this, TelaCardView3::class.java)
            startActivity(telaCardView3)
        }
    }

    // CardView4
    private fun irTelaCardView4() {
        binding.cardView4.setOnClickListener {
            val telaCardView4 = Intent(this, TelaCardView4::class.java)
            startActivity(telaCardView4)
        }
    }

    // CardView5
    private fun irTelaCardView5() {
        binding.cardView5.setOnClickListener {
            val telaCardView5 = Intent(this, TelaCardView5::class.java)
            startActivity(telaCardView5)
        }
    }
}


/*
    *** Usando o ViewBinding ***
        * Em build.gradle, na parte onde tem android {
        * colocar viewBindig { enabled: True} e fazer o sync now - para ser habilitado para o nosso projeto
        * este componente através da unidade dinâmica por meio de um unica variavel apenas,
        * referenciar todos os componetes que temos na unidade dinâmica de cada uma das unidades logicas que temos
        * Dentro da nossa MainActivity ou outra unidade logica, vamos criar uma nova variavel
        * private lateinit var binding do tipo que será a classe gerada pelo viewBinding onde podemos buscar
        * estes componentes que no caso da MainActivity é o ActivityMainBinding (esta classe só existe por causa que habilitamos o viewBinding dentro do projeto)
        * Agora iremos atribuit um novo valor para a variavel binding.
        * Primeiro pegamos a classe ActivityMainBinding (ou FragmentListBinding) e vamos utilizar o metodo inflate
        * E dentro do construtor vamos passar o atributo layoutInflate, agora podemos pegar onde sera inflado este layout
        * que será o container onde estara inserido nosso fragment. (só se caso estiver referenciado componetes para um fragment)
        * vamos mostrar qual o container ele será criado (no nosso caso é o próprio container)
        * vamos colocar em seguida oattachToRoot como false (para fazer o android cuidar de tudo para gente e colocar o fragment dentro do container) (só se caso estiver referenciado componetes para um fragment)
        * E será retornado a raiz do binding, pq é ele que vai cuidar de todos os componentes (return binding.root)
        * agora ao utilizar a variavel de binding é possível ter acesso a todos os componentes que estao dentro da unidade dinamica
        * vamos usar o binding no FormFragment e no restante do projeto
        * Agora todas as classes o componentes são sejam alterados pelo binding.root

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

        ** Criando classe de modelo e lista de modelo para jogar no recylcerView

        * Cada tarefa vai precisar ter alguns dados para ser possível gerar a tarefa
        * Criar um pacote com nome model, para guardar todas as classe de modelo do app
        * Criar um class Tarefa dentro do pacote model (modelo que vai gerar as tarefas)
        * Será uma classe de modelo que irá gerar objetos que contem as infos
        * Para que não precise se preocupar com getter, setter e toString,
        * vamos tonar esta classe uma data Class (classe de dados)
        * e usando o data class faz com que tenhamos todos os metodos getter, setter e toString sobrescritos

        * Dentro da class Tarefa

        * Para esta classe passar a existir e ser possivel fazer uma instancia dela
        * Vamos ter todos os atributos da tarefa (definidos no layout do card_layout)
        * Estes atributos irão dentro de um construtor (var nome: String...)
        * que com que a classe so passe a existir vai precisar obrigatoriamente do construtor
        * Agora já é possivel começar a gerar uma lista de itens
        * contemplando a lista de info da class Tarefa (lista base para ser jogada dentro do recyclerView)

        ** Na class ListFragment

        * Vamos gerar uma lista de itens utilizando o listOf
        * Crie uma val listTarefa: vai guardar uma listagem de tarefas
        * utilizando o componete de list. O listOf vai ser de varios objetos do tipo Tarefa
        * Vamos colocar dentro da listOf cada uma das tarefas declarando um novo objeto do tipo Tarefa
        * e passar as caracteristicas dentro deste objeto. Crie mais tarefas para ter mais itens dentro do card
        * Próximo passo é configurar nosso adapter e por meio dele processar os dados, jogar na nossa lista
        * e fazer eles ficarem colocados dentro do card_layout

        ** Criando Adapter (Para o Recycler View processar os dados)

        * Vamos criar em nosso pacote principal um pacote chamado adapter
        * Na pasta adapter: criar uma Class nomeada como TarefaAdapter

        ** No arquivo TarefaAdapter

        * Para a class TarefaAdapter ser um adapter, precisamos estender ela do RecyclerView.Adapter
        * E para o Adapter ser um adapter é preciso que ele receba um <ViewHolder>
        * O ViewHolder é responsável em jogar nossos itens dentro do nosso card_layout (e jogar isso dentro de uma view)
        * Então, para criar o adapter precisamos criar a classe que vai cuidar da nossa ViewHolder
        * Vamos criar a ViewHolder dentro da class TarefaAdapter.
        * Como é uma classe pequena, podemos fazer isso dentro da TarefaAdapter

        * Vamos criar uma class TarefaViewHolder que estende de RecyclerView.ViewHolder
        * Para a classe conseguir existir e fazer com que ele seja estendido de maneira correta
        * é preciso receber dentro do construtor do RecyclerView uma view
        * esta view será o nosso card_layout
        * Entao nossa class TarefaViewHolder vai receber um construtor onde vamos retornar um objeto do tipo View
        * e vamos passar este parametro para o contrutor da RecyclerView.ViewHolder()
        * deste jeito: class TarefaVIewHolder(view: View) : RecyclerView.ViewHolder(view)

        * É dentro desta ViewHolder que vamos ter que referenciar cada um dos itens que temos dentro do card_layout
        * ou seja, as view do card_layout.
        * Lembrando que toda vez que temos um arq de layout o binding gerar uma classe que pode referenciar todos
        * os componentes que tem dentro dos layouts
        * Entao vamos criar uma variavel dentro do construtor do RecyclerView, no lugar da view que inserimos anteriormente
        * vamos passar uma val binding onde vamos referenciar o nosso CardLayoutBinding, assim agora ele vai ter acesso
        * a todos itens que tem dentro do card_layout.
        * E como queremos retornar nossa view por meio do binding, vamos retornar nosso binding.root
        * no construtor do RecyclerView.ViewHolder(). Agora ele pode retornar nossa view
        * e agora podemos criar cada um dos componente aqui dentro
        * Agora devemos estender a nossa classe do RecyclerView.Adapter passando a viewHolder
        * (TarefaViewHolder) que acabamos de criar
        * desta forma aqui: class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.TarefaVIewHolder>()

        * Agora temos que inserir alguns metodos abstratos de nosso adapter (opção vai aparecer em class TarefaAdapter)
        * Em implement members vamos selecionar os 3 intens que aparecem
        * Agora podemos sobrescrever os 3 métodos que vão ter tudo oq é necessário para conseguir processar nossos
        * itens dentro do nosso adapter

        ** Entendendo como esses 3 metodos funcionam
        * Imagine o tarefa adapter como um For, sempre que ele for criar um novo item (uma nova tarefa)
        * e jogar dentro da nossa lista, ele vai ta rodando um loop.
        * 1- A primeira coisa que ele irá fazer é criar a nossa viewHolder (onCreateViewHolder) e vai
        * criar nosso card, onde ele vai jogar infos da nossa tarefa (este é primeiro metodo a rodar)
        * 2- A partir do momento que ele sabe onde ele vai jogar nossos itens, ele irá rodar o
        * metodo onBindViewHolder onde vamos conseguir conseguir criar nossa tarefa de fato e ir jogando
        * cada um destes itens dentro de cada um dos componentes que temos do card_layout
        * do textNome por exemplo, vamos conseguir recuperar o nome da tarefa
        * 3- O getItemCount vai conseguir retorna para gente o quanto de vezes que ele vai conseguir gerar
        * esses nossos componentes (por exemplo, se a lista tem 5 itens e a partir deste metodo ele vai saber
        * que vai ter que loopar este processo exatamente 5 vezes)

        ** Criando oq vai retornar no onCreateViewHolder

        * O onCreateViewHolder consegue retornar pra gente o tipo de retorno dele é o TarefaViewHolder
        * onde vamos conseguir retornar o nosso binding (do construtor da TarefaViewHolder) que vai conter
        * tudo oq é necessário para a gente conseguir inflar o nosso card_layout
        * Para isso, vamos dar o return de um objeto do tipo TarefaViewHolder()
        * E o TarefaViewHolder() vai precisar retornar um objeto do tipo CardLayoutBiding, para isso
        * temos que passar o CardLayoutBiding.inflate(), e para retornar um objeto deste tipo vamos precisar
        * do layoutInflater, o viewGroup que ele será criado e o attchToParent
        * Vamos criar o layoutInlater do zero: LayoutInflater.from() e dentro dele iremos passar nosso parent.context
        * (parent) a view group que ele está sendo criado
        * (context) o contexto da onde estamos criando este nosso layoutInflater. ViewGroup responsável pelo nosso card_layout
        * passar em qual container ele será criado, nosso parent. E colocar o attchToParent como false
        * Com isso, quando ele for criar o primeiro item da lista ele já sabe que vai criar isso com base no card_layout

        ** Processar dados no onBindViewHolder

        * Verificar dentro do onBindViewHolder como ele vai processar todos os dados dos nossos itens
        * dentro do nosso card_layout
        * Primeiro:
        * Como o TarefaAdapter vai receber uma lista de item no futuro, vamos precisar criar dentro do TarefaAdapter
        * um atributo que possa receber essa lista externa (private var listTarefa) que vai receber no começo uma
        * lista vazia emptyList do tipo Tarefa (criar abaixo da class TarefaAdapter)
        * Quando a gente receber nossa lista, vamos processar os dados desta lista dentro do onBindViewHolder

        * O onBindViewHolder vai sempre recuperar posição atual deste item por meio do position
        * vamos processar ele dentro do card_layout
        * Para recuperar este item na posição atual que ele tem vamos criar uma (val tarefa)
        * que vai receber nossa listTarefa[position] na posição atual que ele tem aqui dentro
        * Vamos começar a processar cada um destes itens que iremos ter dentro desta tarefa, ou seja,
        * o nosso nome, descrição, responsável... (dentro de cada ums dos componentes que terão dentro do card_layout)
        * vamos utilizar o holder e pegar a variavel binding que criamos que tenha referencia dos componentes do card_layout
        * e setar cada um deles com base nas info que temos de cada um dos nossos objetos da minha classe de modelo Tarefa
        * vamos setar o texto dele e vamos pegar o nosso tarefa.nome (queremos a info do componente)
        * Com isso temos todos os textos jogados e processados com base em cada objeto tarefa que vamos ter dentro
        * da listTarefa (todas as tarefas porcessadas nos itens que temos dentro do card_layout)
        * Finalizamos o onBindViewHolder

        ** getItemCount

        * Quantas vezes que o onBindViewHolder vai precisar criar os itens dentro do recyclerView
        * Entao vamos passar dentro do getItemCount o tamanho da nossa lista por meio do return
        * vamos passar nosso retorno com base na nossa listtarefa.size

        ** Para finalizar, vamos criar um metodo para setar a nossa lista

        * Vamos criar um metodo setList e dentro vamos passar uma list do tipo List<Tarefa>
        * e dentro deste metodo vamos trocar o conteudo da nossa lista vazia pela nova lista
        * Entao vamos fazer com que a listTarefa vai receber a list que trouxemos externamente
        * Para fazer com que a list completa seja repaginada vamos avisar o Adapter que foi feito uma mudança
        * na nossa lista como um t0d0 e para isso vamos usar o metodo chamado de notifyDataSetChanged
        * Agora vamos conseguir fazer com que seta nossa lista e ja atualizamos t0d0s os itens que temos dentro do recycler View

        * O que falta é fazer com que dentro do listFragment a gente consiga pegar nosso recycler tarefa e fazer
        * com que ele seja criado com base neste adapter que acabamos de fazer, bora configurar ele

        ** Configurar o RecyclerView dentro do ListFragment

        * Configurando o RecyclerView com base no Adapter que criamos (TarefaAdapter)
        * Vamos configurar o RecyclerView e jogar ele dentro do componente recyclerTarefa (no layout fragment_list)
        * para fazermos nossa lista
        * vamos criar uma variavel para guardar um objeto do nosso TarefaAdapter (val adapter = TarefaAdapter())
        * Vamos acessar nosso recyclerTarefa por meio do binding.
        * E para o recyclerView funcione da maneira correta, para isso vamos:
        * 1 - Configurar quem vai ser o layoutManager deste nosso recyclerTarefa, ou seja, de que forma os itens vao ficar
        * populados dentro da lista (queremos o efeito de um item debaixo do outro).
        * Entao vamos precisar de um LinearLayoutManager(context) e para criar um objeto dele, vamos precisar de um context
        * 2 - Configurar o adapter e vamos fazer ele receber a instancia do nosso adapter
        * 3 - Agora vamos falar para que o recyclerTarefa que todos os itens terá um tamanho fixo com setHasFixedSize(true)

        * Agora vamos deixar o recyclerView com um lista de teste utilizando o listTarefa e para isso:
        * Vamos pegar a instancia do adapter que criamos com .setList(listTarefa)
        * matendo nossa listTarefa que é o parametro que ele recebe
        * setamos o que o recyclerView precisa para ele funcionar (adapter.setList(listTarefa))
        * Em TarefaAdapter, precisamos deixar no listTarefa como private
        * justamente para se possivel setar ela a partir do metodo setList

        *** Padrões de Arquitetura

        * Componentes de Arquitetura

        * Temos um problema quando rotacionamos nossa tela, os dados são perdidos e a tela é recriada novamente
        * Quando viro a tela, ela é destruída e recriada (rodando o onCreate) e nossos dados não sobrevivem a este ciclo de vida
        * Este problema é solucionado com ajuda na ViewModel
        * Vamos separar nossa aplicativo em duas camadas: UI (tela que vai aparecer para o usuario) e um para Persistir os dados

        * Vamos criar uma class MainViewModel (ViewModel principal do aplicativo)
        * Para esta classe ser uma ViewModel precisamos estender ela da nossa classe ViewModel()
        * Esta já consegue ser uma ViewModel e já vai servir para sobreviver ao ciclo de vida da MainActivity
        * Dentra da class MainViewModel vai precisar ter um dado (uma variavel) que vai persistir os valores que ela vai ter
        * E um metodo para colocar mais valores para este dado

        * Agora devemos instanciar este class MainViewModel dentro da MainActivity e fazer
        * ela sobreviver ao ciclo de vida

        ** Na MainActivity

        * vamos instanciar a MainViewModel para conseguir utilizar ela
        * private lateinit var mainViewModel: MainViewModel

        * Depois do setContentView
        * vamos instanciar um objeto da MainViewModel para conseguir sobreviver este ciclo
        * Para conseguir ter este efeito a var mainViewModel vai receber a class ViewModelProvider(this)
        * E este ViewModelProvider fala onde a gente vai instanciar este objeto na nossa MainViewModel,
        * qual o ciclo de vida ele vai seguir.
        * No nosso caso vamos colocar (this), pois será nossa MainActivity que irá cuidar disso
        * Vamo colocar um ponto e usar o metodo get(), onde iremos indicar qual classe da nossa ViewModel vamos
        * colocar aqui, que no nosso caso é a MainViewModel e precisamos converter esta classe para Java
        * mainViewModel = ViewModelProvider(owner: this).get(MainViewModel::class.java)

        * Com essa nossa instanciar agora podemos sobreviver ao ciclo de vida
        * Agora vamos trocar a lógica
        * Vamos pegar os dados da MainViewModel que irá sobreviver ao ciclo de vida da MainActivity mesmo que a tela seja destruida

        ** LiveData

        * O LiveData é uma classe que consegue fazer com que geramos dados que possam ser observados
        * Nossa UI vai ficar observando um dado que fica dentro da nossa MainViewModel
        * e a partir que este dado for alterado, o nosso LiveData vai mandar uma resposta
        * para nossa UI indicando que o dado foi alterado e a nossa UI vai atualizar este dado
        * automaticamente para o usuario

        ** Dentro da Class MainViewModel

        * O LiveData sempre é uma valor imutável. Para ele ser mutável vamos usar um componente chamado de
        * MutableLiveData

        * Vamos pegar o nosso dado (aqui vai depender do que esta sendo usado, uma var ou val) e fazer ele
        * receber um MutableLiveData do tipo da sua val com um valor inicial
        * (exemplo: val cont = MutableLiveData<Int>(0))
        * Tornar um valor observavel
        * Dentro da MainActivity e fazer observar valor a partir do onCreate
        * fazendo a MainActivity ser um observador da variavel definifa como um MutableLiveData

        *** Retrofit

        * - Classe de modelo para quando for fazer as requisições vamos retornar objetos JSON
        * (no nosso caso categoria e tarefa. Vamos precisar de uma classe de modelo para as duas)
        * - Interface de serviço que vai conter todos os metodos HTTP (todos os verbos que vamos utilizar)
        * e um objeto de instância do Retrofit que vai criar o Retorfit no nosso projeto e vai ter a Url base da nossa API
        * - Repositório que vai conseguir pegar os verbos HTTP que é feito na classe de serviço para transformar em metodos
        * - ViewModel onde vamos conseguir processar os dados do repositório e preparar eles para serem mostrados para o usuário

        * Para implementação completa do retrofit vamos precisar ter
        * Primeiro: Dentro do build.gradle(Module) vamos implementar as dependecias do Retrofit e Corrotinas em dependencies
        * Vamos agora implementar as classes de modelo dentro do nosso projeto. Elas irão consistir de basicamente saber quais
        * os dados vai pegar de cada um dos objetos da nossa API. Então vamos montar a classe de modelo com base nos endpoint
        * irão retornar (que é que ta na class Tarefa, que ainda falta implementar o Id:Long)
        * vamos mudar o tipo do atributo categoria, pq ele ira guardar um objeto Categoria, entao vamos

        * Criar uma data Class Categoria no pacote model que terar os atributos
        * var id: Long,
        * var descricao: String,
        * var tarefas: List<Trefa>

        * Feito isso vamos mudar o tipo do atributo categoria de String para Categoria
        * Agora temos as duas classes de modelos (Tarefa e Categoria)
        * com todos os dados que a API precia

        * Agora vamos precisar mudar dentro do nosso dentro do adapter (TarefaAdater)
        * em nosso tarefa.categoria queremos tirar dele nossa descrião e nao o objeto tod0
        *
*/