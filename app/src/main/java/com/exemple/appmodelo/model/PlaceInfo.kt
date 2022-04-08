// O package model é um pacote para classes que modelam (ou representam) dados.
package com.exemple.appmodelo.model

// A instância de objeto de PlaceInfo representa os dados dos Places
// e contém o ID do recurso da string com os dados dos Places.
// é necessário transmitir o ID do recurso para a string de place1_card1.
// O ID do recurso é um número inteiro. Por isso o parâmetro.
data class PlaceInfo(val stringResourceId: Int) {
}