package com.healthcare.cats.features.cat.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.SubcomposeAsyncImage
import com.healthcare.cats.features.cat.presentation.components.CatBottomBar
import com.healthcare.cats.features.cat.presentation.components.CatCentreAlignTopAppBar
import com.healthcare.cats.ui.theme.CatsTheme

@Composable
fun CatScreen(
    modifier: Modifier = Modifier,
    viewModel: CatViewModel = viewModel()
) {
    val catUiState by viewModel.uiState.collectAsStateWithLifecycle()

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
            cat = catUiState,
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
        LazyColumn(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ) {
                    SubcomposeAsyncImage(
                        modifier = Modifier.size(300.dp),
                        model = cat.imageUrl,
                        contentDescription = null,
                        loading = {
                            CircularProgressIndicator()
                        },
                        contentScale = ContentScale.Crop
                    )
                }
            }
            item {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = cat.name,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.W500
                )
            }
            item {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = cat.description,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyLarge
                )

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CatScreenPreview() {
    CatsTheme {
        CatScreenContent(
            cat = CatUiState(
                "Barsik",
                "Have a great mood!",
                "",
            )
        )
    }
}
