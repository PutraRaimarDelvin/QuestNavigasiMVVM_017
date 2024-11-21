package com.example.navigasi.ui.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import com.example.navigasi.model.Mahasiswa


@Composable
fun DetailMahasiswaView(
    dataMhs : Mahasiswa,
    onBackButtonClicked: () ->Unit,
    modifier: Modifier = Modifier


){
    val listDataMhs = listOf(
        Pair("Nama", dataMhs.nama),
        Pair("Gender", dataMhs.gender),
        Pair("Alamat", dataMhs.alamat),
        Pair("email", dataMhs.email),
        Pair("nohp", dataMhs.nohp),


        )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        listDataMhs.forEach { data->
            DetailMhs(
                judul = data.first,
                Isi = data.second
            )
        }

        Button(onClick = {onBackButtonClicked()}) {
            Text(text = "Kembali")
        }
    }
}

@Composable
fun DetailMhs(
    judul: String,
    Isi : String,
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Text(judul,
            modifier = Modifier.weight(0.8f))
        Text(":",
            modifier = Modifier.weight(0.1f))
        Text(Isi,
            modifier = Modifier.weight(2f))
    }
}