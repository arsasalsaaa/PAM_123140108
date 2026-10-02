package com.example.p3_123140108.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p3_123140108.data.ProfileUiState
import com.example.p3_123140108.ui.components.LabeledTextField
import com.example.p3_123140108.ui.components.ProfileCard
import com.example.p3_123140108.ui.components.ProfileHeader

/**
 * Edit Profile Form view with state hoisting using [LabeledTextField].
 */
@Composable
fun EditProfileScreen(
    uiState: ProfileUiState,
    onNameChange: (String) -> Unit,
    onSubtitleChange: (String) -> Unit,
    onBioChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onLocationChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    onCancelClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            ProfileHeader(
                name = uiState.editName.ifEmpty { "Edit Name" },
                subtitle = uiState.editSubtitle.ifEmpty { "Edit Subtitle" },
                headerTitle = "Edit Profile",
                onBackClick = onCancelClick,
            )

            // Form Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-36).dp)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ProfileCard(title = "Form Edit Profil") {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        LabeledTextField(
                            label = "Nama Lengkap",
                            value = uiState.editName,
                            onValueChange = onNameChange,
                            placeholder = "Masukkan nama lengkap",
                        )

                        LabeledTextField(
                            label = "Subtitle / Role",
                            value = uiState.editSubtitle,
                            onValueChange = onSubtitleChange,
                            placeholder = "Masukkan subtitle/role",
                        )

                        LabeledTextField(
                            label = "Bio",
                            value = uiState.editBio,
                            onValueChange = onBioChange,
                            singleLine = false,
                            maxLines = 4,
                            placeholder = "Masukkan bio singkat",
                        )

                        LabeledTextField(
                            label = "Email",
                            value = uiState.editEmail,
                            onValueChange = onEmailChange,
                            placeholder = "Masukkan email",
                        )

                        LabeledTextField(
                            label = "Phone",
                            value = uiState.editPhone,
                            onValueChange = onPhoneChange,
                            placeholder = "Masukkan nomor telepon",
                        )

                        LabeledTextField(
                            label = "Location",
                            value = uiState.editLocation,
                            onValueChange = onLocationChange,
                            placeholder = "Masukkan lokasi",
                        )
                    }
                }


                // Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = onCancelClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colorScheme.primary,
                        )
                    ) {
                        Text(
                            text = "Batal",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                        )
                    }

                    Button(
                        onClick = onSaveClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary,
                        )
                    ) {
                        Text(
                            text = "Simpan",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
