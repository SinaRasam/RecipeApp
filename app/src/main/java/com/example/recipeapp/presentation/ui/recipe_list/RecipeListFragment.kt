package com.example.recipeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.recipeapp.presentation.BaseApplication
import com.example.recipeapp.presentation.components.AnimationList.ShimmerAnimation1
import com.example.recipeapp.presentation.components.CircularIndeterminateProgressBar
import com.example.recipeapp.presentation.components.RecipeCard
import com.example.recipeapp.presentation.components.SearchAppBar
import com.example.recipeapp.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val viewModel: RecipeListViewModel by viewModels()

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                AppTheme(darkTheme = application.isDark.value) {
                    val keyboardController = LocalSoftwareKeyboardController.current

                    val recipes = viewModel.recipes.value
                    val query = viewModel.query.value
                    //val query =  savedInstanceState{ "beef"}
                    //val query = remember { mutableStateOf("beef") }
                    val selectedCategory = viewModel.selectedCategory.value
                    val loading = viewModel.loading.value

                    Column {
                        SearchAppBar(
                            query = query,
                            onQueryChanged = viewModel::onQueryChanged,
                            onExecuteSearch = viewModel::newSearch,
                            scrollPosition = viewModel.categoryScrollPosition,
                            selectedCategory = selectedCategory,
                            onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                            onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition,
                            keyboardController = keyboardController,
                            onToggleTheme ={
                                application.toggleLightTheme()
                            }
                        )

                        Box(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.background)) {
                            if(loading){
                                val scrollState = rememberScrollState()

                                Column(
                                    modifier = Modifier
                                        .verticalScroll(scrollState)
                                ) {
                                    repeat(8) {
                                        ShimmerAnimation1()
                                    }
                                }
                            }else{
                                LazyColumn {
                                    itemsIndexed(
                                        items = recipes
                                    ) { index, recipes ->
                                        RecipeCard(recipe = recipes, onClick = {})
                                    }
                                }
                            }
                            CircularIndeterminateProgressBar(isDisplayed = loading)
                        }

                    }

                }

            }
        }
    }
}