package com.example.p3_123140108.data

/**
 * UI State data class representing the state of Profile Screen.
 * Contains profile information, dark mode flag, and editing state.
 */
data class ProfileUiState(
    val name: String = "Arsa Salsabila",
    val subtitle: String = "Mahasiswa Teknik Informatika ITERA '23",
    val bio: String = "Mahasiswa Teknik Informatika di ITERA yang antusias dengan pengembangan aplikasi mobile, keamanan siber, dan eksplorasi teknologi modern.",
    val email: String = "arsa.123140108@student.itera.ac.id",
    val phone: String = "+62 896-8877-123",
    val location: String = "Bandar Lampung, Indonesia",
    val isDarkMode: Boolean = false,
    val isEditing: Boolean = false,
    val editName: String = "",
    val editSubtitle: String = "",
    val editBio: String = "",
    val editEmail: String = "",
    val editPhone: String = "",
    val editLocation: String = "",
)
