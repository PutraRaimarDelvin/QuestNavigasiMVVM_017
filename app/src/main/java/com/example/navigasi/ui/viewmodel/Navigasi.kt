package com.example.navigasi.ui.viewmodel

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasi.model.ListGender
import com.example.navigasi.ui.view.DetailMahasiswaView
import com.example.navigasi.ui.view.FormulirMahasiswaView


enum class Halaman{
    Form,
    Data
}

@Composable
fun Navigasi(
    modifier: Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {
    Scaffold { isipadding ->
        val uiState by viewModel.dataModel.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost,
            startDestination = Halaman.Form.name
        ) {

            composable(route = Halaman.Form.name) {
                val konteks = LocalContext.current
                FormulirMahasiswaView(
                    listgender = ListGender.listGender.map { id ->
                        konteks.getString(id)
                    },
                    onClickButton = {
                        viewModel.saveDataMhs(it)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }
            composable(route = Halaman.Data.name)
            {
                DetailMahasiswaView(
                    dataMhs = uiState,
                    modifier = Modifier,
                    onBackButtonClicked = {
                        navHost.popBackStack()
                    }
                )
            }

        }


    }

}

