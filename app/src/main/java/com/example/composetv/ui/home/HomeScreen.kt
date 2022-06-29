package com.example.composetv.ui.home

import android.R
import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.atLeast
import coil.compose.rememberImagePainter
import org.intellij.lang.annotations.JdkConstants


@Composable
fun HomeScreen(
    title: String,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(title)
                },
                actions = {
                    ActionButton(
                        { Log.d("test", "test1") },
                        Icons.Filled.Favorite,
                        "Localized description"
                    )
                    ActionButton(
                        { Log.d("test", "test2") },
                        Icons.Filled.Favorite,
                        "Localized description"
                    )
                    ActionButton(
                        { Log.d("test", "test3") },
                        Icons.Filled.Favorite,
                        "Localized description"
                    )
                    ActionButton(
                        { Log.d("test", "test4") },
                        Icons.Filled.Favorite,
                        "Localized description"
                    )
                }
            )
        },
        bottomBar = { BottomNavigation() }
    ) { innerPadding ->
        val mainScrollState = rememberScrollState()
        Column(
            Modifier
                .background(MaterialTheme.colors.background)
                .verticalScroll(mainScrollState)
                .padding(innerPadding)
        ) {
            CategoryList()
            Spacer(modifier = Modifier.heightIn(14.dp))
            SummerLeagueList()
            Spacer(modifier = Modifier.heightIn(14.dp))
        }
    }
}


@Composable
fun Section(
    sectionTitle: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier.background(Color.Transparent)) {
        Text(
            text = sectionTitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}


@Composable
fun SummerLeagueList() {
    val summerLeagueScrollState = rememberLazyListState()
    Section("2022 LCK 챌린저스 리그 서머") {
        LazyRow(
            state = summerLeagueScrollState,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(20) {
                LeagueItem()
            }
        }
    }
}

@Composable
fun CategoryList() {
    val categoryScrollState = rememberLazyListState()
    Section("카테고리") {
        LazyRow(
            state = categoryScrollState,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(20) {
                CategoryItem()
            }
        }
    }
}

@Composable
fun CategoryItem() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(250.dp)
                .clip(RoundedCornerShape(4.dp))
        ) {
            Image(
                painter = rememberImagePainter(
                    data = "https://picsum.photos/200/300"
                ),
                contentDescription = "CategoryTitle",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier.align(
                    Alignment.BottomCenter
                )
            ) {
                Icon(
                    imageVector = Icons.Default.People,
                    contentDescription = "참여자수",
                )
                Text("999,999", color = Color.White)
            }
        }
        Text(
            text = "게임",
            modifier = Modifier
                .padding(top = 14.dp)
        )
    }
}

@Composable
fun LeagueItem() {
    ConstraintLayout(
        modifier = Modifier
            .padding(14.dp)
            .background(
                Color.LightGray,
                shape = RoundedCornerShape(14.dp)
            )
            .clickable {

            }
    ) {
        val (img, padding, boradInfo) = createRefs()
        Image(
            painter = rememberImagePainter(
                data = "https://picsum.photos/200/300"
            ),
            contentDescription = "CategoryTitle",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp))
                .constrainAs(img) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(padding.start)
                }
        )
        Spacer(modifier = Modifier
            .width(16.dp)
            .constrainAs(padding) {
                start.linkTo(img.end)
                top.linkTo(parent.top)
                end.linkTo(boradInfo.start)
                bottom.linkTo(parent.bottom)
            })
        Column(
            modifier = Modifier
                .padding(14.dp)
                .constrainAs(boradInfo) {
                    start.linkTo(padding.end)
                    end.linkTo(parent.end)
                }
        ) {
            Text(
                text = "방송 제목",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row() {
                Image(
                    painter = rememberImagePainter(
                        data = "https://picsum.photos/200"
                    ),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(36.dp)
                        .height(36.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp)
                ) {
                    Text("챌린저스공식")
                    Row {
                        Icon(
                            imageVector = Icons.Default.VideogameAsset,
                            contentDescription = "참여자수",
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "20,000"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ActionButton(callback: () -> Unit, icon: ImageVector, desc: String) {
    IconButton(onClick = callback) {
        Icon(icon, desc)
    }
}

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(modifier) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "홈"
                )
            },
            label = {
                Text("홈")
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.VideogameAsset,
                    contentDescription = "e스포츠"
                )
            },
            label = {
                Text("e스포츠")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.FeaturedVideo,
                    contentDescription = "VOD"
                )
            },
            label = {
                Text("VOD")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "MY"
                )
            },
            label = {
                Text("VOD")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.PlusOne,
                    contentDescription = "더보기"
                )
            },
            label = {
                Text("더보기")
            },
            selected = false,
            onClick = {}
        )
    }
}