package com.example.p3_123140108.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p3_123140108.data.ProfileUiState
import com.example.p3_123140108.ui.components.InfoItem
import com.example.p3_123140108.ui.components.ProfileCard
import com.example.p3_123140108.ui.components.ProfileHeader
import com.example.p3_123140108.ui.components.ProfileIcons
import com.example.p3_123140108.ui.theme.ProfileAppTheme
import com.example.p3_123140108.viewmodel.ProfileViewModel

/**
 * Main Profile Screen displaying profile information, dark mode switch, and edit option.
 */
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel { ProfileViewModel() },
) {
    val uiState by viewModel.uiState.collectAsState()

    ProfileAppTheme(isDarkMode = uiState.isDarkMode) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            if (uiState.isEditing) {
                EditProfileScreen(
                    uiState = uiState,
                    onNameChange = viewModel::onNameChange,
                    onSubtitleChange = viewModel::onSubtitleChange,
                    onBioChange = viewModel::onBioChange,
                    onEmailChange = viewModel::onEmailChange,
                    onPhoneChange = viewModel::onPhoneChange,
                    onLocationChange = viewModel::onLocationChange,
                    onSaveClick = viewModel::saveProfile,
                    onCancelClick = viewModel::cancelEditing,
                )
            } else {
                ProfileContent(
                    uiState = uiState,
                    onDarkModeToggle = viewModel::toggleDarkMode,
                    onEditClick = viewModel::startEditing,
                )
            }
        }
    }
}

@Composable
fun ProfileContent(
    uiState: ProfileUiState,
    onDarkModeToggle: () -> Unit,
    onEditClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header Section
            ProfileHeader(
                name = uiState.name,
                subtitle = uiState.subtitle,
                onBackClick = { /* Handle back action */ },
                actions = {
                    IconButton(onClick = onDarkModeToggle) {
                        Icon(
                            painter = rememberVectorPainter(
                                if (uiState.isDarkMode) ProfileIcons.Sun else ProfileIcons.Moon
                            ),
                            contentDescription = "Toggle Dark Mode",
                            tint = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                }
            )

            // Overlapping Content Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-36).dp)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Dark Mode Switch Card
                ProfileCard(title = "Settings") {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Icon(
                                painter = rememberVectorPainter(
                                    if (uiState.isDarkMode) ProfileIcons.Moon else ProfileIcons.Sun
                                ),
                                contentDescription = "Dark Mode",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(24.dp),
                            )
                            Column {
                                Text(
                                    text = "Dark Mode",
                                    color = MaterialTheme.colorScheme.onSurface,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                )
                                Text(
                                    text = if (uiState.isDarkMode) "Tema Gelap Aktif" else "Tema Terang Aktif",
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    fontSize = 12.sp,
                                )
                            }
                        }

                        Switch(
                            checked = uiState.isDarkMode,
                            onCheckedChange = { onDarkModeToggle() },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                                checkedTrackColor = MaterialTheme.colorScheme.primary,
                                uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                                uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant,
                            )
                        )
                    }
                }

                // Bio Card Section
                ProfileCard(title = "Bio") {
                    Text(
                        text = uiState.bio,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 13.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }

                // Information Card Section
                ProfileCard(title = "Information") {
                    InfoItem(
                        icon = ProfileIcons.Email,
                        label = "Email",
                        value = uiState.email,
                        showDivider = true,
                    )

                    InfoItem(
                        icon = ProfileIcons.Phone,
                        label = "Phone",
                        value = uiState.phone,
                        showDivider = true,
                    )

                    InfoItem(
                        icon = ProfileIcons.Location,
                        label = "Location",
                        value = uiState.location,
                        showDivider = false,
                    )
                }

                // Action Button (Edit Profile)
                Button(
                    onClick = onEditClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = rememberVectorPainter(ProfileIcons.Edit),
                            contentDescription = "Edit Profile",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(18.dp),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Edit Profile",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
