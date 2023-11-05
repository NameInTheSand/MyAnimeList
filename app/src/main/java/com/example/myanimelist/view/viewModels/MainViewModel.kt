package com.example.animelist.view.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myanimelist.data.entities.AnimeEntity
import com.example.myanimelist.data.repositories.RepositoriesLocator
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = RepositoriesLocator.animeRepository

    private val _animeLisLiveData = MutableLiveData<List<AnimeEntity>>()
    val animeLisLiveData: LiveData<List<AnimeEntity>> = _animeLisLiveData

    fun initData() {
        viewModelScope.launch {
            repository.getAnimeList().collect {
                _animeLisLiveData.value = it
            }
        }
    }

    fun insertEntity(animeEntity: AnimeEntity) {
        viewModelScope.launch {
            repository.insertAnime(animeEntity)
        }
    }

    fun updateEntity(animeEntity: AnimeEntity) {
        viewModelScope.launch {
            repository.updateAnime(animeEntity)
        }
    }

}