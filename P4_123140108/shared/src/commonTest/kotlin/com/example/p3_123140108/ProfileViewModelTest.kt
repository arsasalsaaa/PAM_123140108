package com.example.p3_123140108

import com.example.p3_123140108.viewmodel.ProfileViewModel
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ProfileViewModelTest {

    @Test
    fun testInitialState() {
        val viewModel = ProfileViewModel()
        val state = viewModel.uiState.value

        assertEquals("Arsa Salsabila", state.name)
        assertFalse(state.isDarkMode)
        assertFalse(state.isEditing)
    }

    @Test
    fun testToggleDarkMode() {
        val viewModel = ProfileViewModel()
        assertFalse(viewModel.uiState.value.isDarkMode)

        viewModel.toggleDarkMode()
        assertTrue(viewModel.uiState.value.isDarkMode)

        viewModel.toggleDarkMode()
        assertFalse(viewModel.uiState.value.isDarkMode)
    }

    @Test
    fun testStartAndSaveEditing() {
        val viewModel = ProfileViewModel()
        
        viewModel.startEditing()
        assertTrue(viewModel.uiState.value.isEditing)
        assertEquals("Arsa Salsabila", viewModel.uiState.value.editName)

        viewModel.onNameChange("Arsa Salsabila Updated")
        viewModel.onBioChange("New Bio Test")
        viewModel.saveProfile()

        val updatedState = viewModel.uiState.value
        assertFalse(updatedState.isEditing)
        assertEquals("Arsa Salsabila Updated", updatedState.name)
        assertEquals("New Bio Test", updatedState.bio)
    }

    @Test
    fun testCancelEditing() {
        val viewModel = ProfileViewModel()
        
        viewModel.startEditing()
        viewModel.onNameChange("Should Not Save")
        viewModel.cancelEditing()

        val state = viewModel.uiState.value
        assertFalse(state.isEditing)
        assertEquals("Arsa Salsabila", state.name)
    }
}
