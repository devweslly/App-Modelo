package com.exemple.appmodelo.data

import com.exemple.appmodelo.R
import com.exemple.appmodelo.model.PlaceInfo

// classe Datasource prepara os dados para o app.
// E preparação de dados é uma questão separada, por isso o pacote data.
class Datasource {
    // A fun loadPlaceInfo() precisa retornar uma lista de PlaceInfo.
    // Isso é feito criando uma lista que preencha com uma
    // instância PlaceInfo para cada string de recurso.
    fun loadPlaceInfo(): List<PlaceInfo>{
        return listOf<PlaceInfo>(
            PlaceInfo(R.string.place1_card1),
            PlaceInfo(R.string.place2_card1),
            PlaceInfo(R.string.place3_card1),
            PlaceInfo(R.string.place4_card1),
            PlaceInfo(R.string.place5_card1)
        )
    }
}