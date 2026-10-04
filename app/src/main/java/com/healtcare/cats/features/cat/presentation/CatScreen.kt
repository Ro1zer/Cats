package com.healtcare.cats.features.cat.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.healtcare.cats.R
import com.healtcare.cats.features.cat.presentation.components.CatBottomBar
import com.healtcare.cats.features.cat.presentation.components.CatCentreAlignTopAppBar
import com.healtcare.cats.ui.theme.CatsTheme

@Composable
fun CatScreen(
    modifier: Modifier = Modifier,
    viewModel: CatViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = ::CatCentreAlignTopAppBar,
        bottomBar = {
            CatBottomBar(
                onNextClick = {
                    viewModel.nextCat()
                },
                onBackClick = {
                    viewModel.previousCat()
                }
            )
        }
    ) { innerPadding ->
        CatScreenContent(
            cat = uiState,
            modifier = Modifier.padding(innerPadding)
        )
    }

}

@Composable
fun CatScreenContent(
    cat: CatUiState,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Card(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ) {
                Image(
                    modifier = Modifier.size(300.dp),
                    painter = painterResource(R.drawable.cat_1),
                    contentDescription = "Image with cat",
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = cat.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W500
            )
            Text(
                text = cat.description,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CatScreenPreview() {
    CatsTheme {
        CatScreenContent(
            cat = CatUiState("Barsik", "Have a grea mood!")
        )
    }
}
