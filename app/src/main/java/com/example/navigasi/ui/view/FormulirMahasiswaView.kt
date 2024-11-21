package com.example.navigasi.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormulirMahasiswaView(
    modifier: Modifier = Modifier,
    listgender: List<String>,
    onClickButton: (MutableList<String>) -> Unit
){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nohp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jeniskelamin by remember { mutableStateOf("") }
    var listData : MutableList<String> = mutableListOf(nama,jeniskelamin, email, nohp, alamat)

    Column (modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("BIO",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Name") },
            placeholder = {
                Text("Masukkan Nama Anda!", color = Color.Gray)
            }
        )
        Row {
            listgender.forEach{selectedJK ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = jeniskelamin == selectedJK,
                        onClick = {
                            jeniskelamin = selectedJK
                        })
                    Text(selectedJK)
                }
            }
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Email") },
            placeholder = {
                Text("Masukkan Email Anda!", color = Color.Gray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = nohp,
            onValueChange = {nohp = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("No Handphone") },
            placeholder = {
                Text("Masukkan Nomer HP", color = Color.Gray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Alamat") },
            placeholder = {
                Text("Masukkan Alamat Anda!", color = Color.Gray)
            }
        )

        Button(onClick = {
            onClickButton(listData)
        }, modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Submit")
        }
    }
}