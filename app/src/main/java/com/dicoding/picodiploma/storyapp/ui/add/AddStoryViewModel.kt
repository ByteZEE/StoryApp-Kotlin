package com.dicoding.picodiploma.storyapp.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.picodiploma.storyapp.model.Result
import com.dicoding.picodiploma.storyapp.model.SessionModel
import com.dicoding.picodiploma.storyapp.model.StoryRepository
import com.dicoding.picodiploma.storyapp.service.response.AddStoryResponse
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody

class AddStoryViewModel(private val repository: StoryRepository) : ViewModel() {
    val addStoryResponse: LiveData<AddStoryResponse> = repository.addStoryResponse
    val isLoading: LiveData<Boolean> = repository.isLoading
    val toastText: LiveData<Result<String>> = repository.toastText


    fun addStory(token: String, file: MultipartBody.Part, description: RequestBody) {
        viewModelScope.launch {
            repository.addStory(token, file, description)
        }
    }

    fun getSession(): LiveData<SessionModel> {
        return repository.getSession()
    }
}