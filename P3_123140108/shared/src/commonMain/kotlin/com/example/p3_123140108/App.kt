package com.example.p3_123140108

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.p3_123140108.components.InfoItem
import com.example.p3_123140108.components.ProfileCard
import com.example.p3_123140108.components.ProfileHeader
import com.example.p3_123140108.components.ProfileIcons

private val CustomLightColorScheme = lightColorScheme(
    primary = Color(0xFF573826),
    onPrimary = Color(0xFFFB9E69),
    background = Color(0xFFF8F4F0),
    surface = Color(0xFFFEF3EC),
    onBackground = Color(0xFF5B3F2E),
    onSurface = Color(0xFF5B3F2E)
)

@Composable
@Preview
fun App() {
    MaterialTheme(colorScheme = CustomLightColorScheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF8F4F0)
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
                    // Header Section (Full Width Kanan-Kiri)
                    ProfileHeader(
                        name = "Arsa Salsabila",
                        subtitle = "Mahasiswa Teknik Informatika ITERA '23",
                        onBackClick = { /* Handle back action */ }
                    )

                    // Overlapping Content Section (Card Bio, Information, Edit Profile Button)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = (-36).dp)
                            .padding(horizontal = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Bio Card Section (Menimpah/Overlap dengan Card Name Header)
                        ProfileCard(
                            title = "Bio"
                        ) {
                            Text(
                                text = "Mahasiswa Teknik Informatika di ITERA yang antusias dengan pengembangan aplikasi mobile, keamanan siber, dan eksplorasi teknologi modern",
                                color = Color(0xFF5B3F2E),
                                fontSize = 13.sp,
                                lineHeight = 18.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }

                        // Information Card Section
                        ProfileCard(
                            title = "Information"
                        ) {
                            InfoItem(
                                icon = ProfileIcons.Email,
                                label = "Email",
                                value = "arsa.123140108@student.itera.ac.id",
                                showDivider = true
                            )

                            InfoItem(
                                icon = ProfileIcons.Phone,
                                label = "Phone",
                                value = "+62 896-8877-123",
                                showDivider = true
                            )

                            InfoItem(
                                icon = ProfileIcons.Location,
                                label = "Location",
                                value = "Bandar Lampung, Indonesia",
                                showDivider = false
                            )
                        }

                        // Action Button (Edit Profile)
                        Button(
                            onClick = { /* Action Edit Profile */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF573826),
                                contentColor = Color(0xFFFB9E69)
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
                                    tint = Color(0xFFFB9E69),
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Edit Profile",
                                    color = Color(0xFFFB9E69),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}