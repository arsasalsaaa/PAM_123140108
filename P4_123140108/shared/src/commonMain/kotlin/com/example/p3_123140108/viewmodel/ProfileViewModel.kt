package com.example.p3_123140108.viewmodel

import androidx.lifecycle.ViewModel
import com.example.p3_123140108.data.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel for Profile Screen using StateFlow and Reactive MVVM architecture.
 */
class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun toggleDarkMode() {
        _uiState.update { currentState ->
            currentState.copy(isDarkMode = !currentState.isDarkMode)
        }
    }

    fun startEditing() {
        _uiState.update { currentState ->
            currentState.copy(
                isEditing = true,
                editName = currentState.name,
                editSubtitle = currentState.subtitle,
                editBio = currentState.bio,
                editEmail = currentState.email,
                editPhone = currentState.phone,
                editLocation = currentState.location,
            )
        }
    }

    fun cancelEditing() {
        _uiState.update { currentState ->
            currentState.copy(isEditing = false)
        }
    }

    fun onNameChange(newName: String) {
        _uiState.update { it.copy(editName = newName) }
    }

    fun onSubtitleChange(newSubtitle: String) {
        _uiState.update { it.copy(editSubtitle = newSubtitle) }
    }

    fun onBioChange(newBio: String) {
        _uiState.update { it.copy(editBio = newBio) }
    }

    fun onEmailChange(newEmail: String) {
        _uiState.update { it.copy(editEmail = newEmail) }
    }

    fun onPhoneChange(newPhone: String) {
        _uiState.update { it.copy(editPhone = newPhone) }
    }

    fun onLocationChange(newLocation: String) {
        _uiState.update { it.copy(editLocation = newLocation) }
    }

    fun saveProfile() {
        _uiState.update { currentState ->
            currentState.copy(
                name = currentState.editName,
                subtitle = currentState.editSubtitle,
                bio = currentState.editBio,
                email = currentState.editEmail,
                phone = currentState.editPhone,
                location = currentState.editLocation,
                isEditing = false,
            )
        }
    }
}
