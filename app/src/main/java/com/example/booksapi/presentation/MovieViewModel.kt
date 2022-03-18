package com.example.booksapi.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksapi.api.ApiService
import com.example.booksapi.api.dto.Movie
import kotlinx.coroutines.launch
import java.lang.Error

class MovieViewModel: ViewModel() {
    var movieListResponse: List<Movie> by  mutableStateOf(listOf())
    var errorMessage: String  by mutableStateOf("")

    fun getMovieList(){
        viewModelScope.launch {
            var apiService = ApiService.getInstance()
            try {
                var movieList = apiService.getMovies()
                movieListResponse = movieList

            }
            catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }

}