import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        Surface(
            color = Color(0xFFFFFFFF)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier.wrapContentSize()
                        .offset(x = (-118).dp, y = (-22).dp)
                ) {
                    Box(
                        modifier = Modifier.size(411.dp)
                            .blur(radius = 200.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                            .padding(top = 24.dp, start = 15.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color(0xFFFF7BCA),
                                        Color(0xFFFFC56F).copy(alpha = 0.46f)
                                    )
                                )
                            )
                    )
                    Box(
                        modifier = Modifier.size(300.dp)
                            .blur(radius = 100.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                            .clip(CircleShape)
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color(0xFFF22FB0),
                                        Color(0x007061A3)
                                    )
                                )
                            )
                    )
                }

                Box(
                    modifier = Modifier.wrapContentSize()
                        .align(Alignment.BottomEnd)
                        .offset(y = 106.dp, x = 93.dp)
                ) {
                    Box(
                        modifier = Modifier.size(285.dp)
                            .blur(radius = 200.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                            .padding(top = 17.dp, start = 10.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color(0xFFFF7BCA),
                                        Color(0xFFFFC56F).copy(alpha = 0.46f)
                                    )
                                )
                            )
                    )
                    Box(
                        modifier = Modifier.size(208.dp)
                            .blur(radius = 100.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                            .clip(CircleShape)
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color(0xFFF22FB0),
                                        Color(0x007061A3)
                                    )
                                )
                            )
                    )
                }

                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(horizontal = 180.dp)
                ) {
                    Spacer(Modifier.height(24.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Gun!",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF111827),
                            )
                        )
                        Spacer(modifier = Modifier.width(354.dp))
                        ScrollableTabRow(
                            selectedTabIndex = 0,
                            backgroundColor = Color.Transparent,
                            modifier = Modifier.weight(1f),
                            indicator = {}
                        ) {
                            Tab(
                                selected = true,
                                onClick = {}
                            ) {
                                Text(
                                    text = "Tentang",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF374151),
                                    ),
                                    modifier = Modifier.padding(bottom = 4.dp, end = 44.dp)
                                )
                            }

                            Tab(selected = false, onClick = {}) {
                                Text(
                                    text = "Portofolio",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF374151),
                                    ),
                                    modifier = Modifier.padding(bottom = 4.dp, end = 44.dp)
                                )
                            }
                        }
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = null,
                            tint = Color(0xFF374151)
                        )
                    }
                    Spacer(Modifier.height(44.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(24.dp),
                            modifier = Modifier.weight(1f).padding(top = 124.dp)
                        ) {
                            Spacer(Modifier.height(20.dp))
                            Text(
                                text = "Halo! Saya Gunawan.\nSeorang Designer dan \nDeveloper",
                                style = TextStyle(
                                    fontSize = 36.sp,
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFF1F2937),
                                )
                            )
                            Text(
                                text = "Passionate di bidang Frontend Dev dan UI/UX Design. Suka membangun\n" +
                                        " antarmuka website yang fast-performace dan well-design menggunakan\n" +
                                        "teknologi-teknologi terbaru.",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF374151),
                                )
                            )
                            Row(
                                modifier = Modifier
                                    .width(187.dp)
                                    .height(48.dp)
                                    .background(
                                        color = Color(0xFF1F2937),
                                        shape = RoundedCornerShape(size = 4.dp)
                                    ),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Lihat Portfolio",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFF9FAFB),
                                    )
                                )
                                Icon(
                                    imageVector = Icons.Filled.ArrowForward,
                                    contentDescription = null,
                                    tint = Color(0xFFF9FAFB)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(136.dp))
                        Box(
                            modifier = Modifier.weight(1f).padding(bottom = 86.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource("myshot.png"),
                                contentDescription = "Anwar Hussen",
                                modifier = Modifier.fillMaxWidth()
                                    .wrapContentHeight()
                            )
                        }
                    }
                }
            }
        }
    }
}