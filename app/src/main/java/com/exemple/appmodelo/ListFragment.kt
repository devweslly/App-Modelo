package com.exemple.appmodelo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.exemple.appmodelo.adapter.TarefaAdapter
import com.exemple.appmodelo.databinding.FragmentListBinding
import com.exemple.appmodelo.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Lista padrão configurada
        val listTarefa = listOf(
            Tarefa(
                "Lavar a louça",
                "O dia inteiro",
                "Weslly",
                "2022-06-27",
                false,
                "Dia-a-Dia"
            ),
            Tarefa(
                "Lavar cabelo",
                "As 14h30",
                "Weslly",
                "2022-06-27",
                false,
                "Dia-a-Dia"
            ),
            Tarefa(
                "Estudar ReciclerView",
                "Depois do bootcamp",
                "Weslly",
                "2022-06-27",
                false,
                "Dia-a-Dia"
            ),
        )

        //Configurando o RecyclerView
        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        adapter.setList(listTarefa)

        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }
}