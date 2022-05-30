package com.dicoding.picodiploma.storyapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dicoding.picodiploma.storyapp.model.Result
import com.dicoding.picodiploma.storyapp.model.SessionModel
import com.dicoding.picodiploma.storyapp.model.StoryRepository
import com.dicoding.picodiploma.storyapp.service.response.ListStoryItem
import com.dicoding.picodiploma.storyapp.service.response.StoriesResponse
import kotlinx.coroutines.launch

class MainViewModel(private val repository: StoryRepository) : ViewModel() {
    val list: LiveData<StoriesResponse> = repository.list
    val isLoading: LiveData<Boolean> = repository.isLoading
    val toastText: LiveData<Result<String>> = repository.toastText
    val getListStory: LiveData<PagingData<ListStoryItem>> = repository.getStories().cachedIn(viewModelScope)

    fun getSession(): LiveData<SessionModel> {
        return repository.getSession()
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

    fun getListStoryLocation(token: String) {
        viewModelScope.launch {
            repository.getListStoryLocation(token)
        }
    }
}