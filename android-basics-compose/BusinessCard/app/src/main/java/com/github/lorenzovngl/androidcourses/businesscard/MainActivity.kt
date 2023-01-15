package com.github.lorenzovngl.androidcourses.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.lorenzovngl.androidcourses.businesscard.ui.theme.BusinessCardTheme
import com.github.lorenzovngl.androidcourses.businesscard.ui.theme.androidGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                BusinessCard(
                    name = "Lorenzo Vainigli",
                    title = "Android Developer",
                    phone = "+11 (123) 444 555 666",
                    social = "@lorenzovngl",
                    email = "lorenzovngl@gmail.com"
                )
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title: String, phone: String, social: String, email: String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF073042)
    ) {
        Column {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.8f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = "Android Logo",
                    modifier = Modifier.width(100.dp)
                )
                Text(
                    text = name,
                    fontWeight = FontWeight.Light,
                    fontSize = 42.sp,
                    color = Color.White,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = androidGreen
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.2f)
            ) {
                ContactItem(
                    icon = Icons.Rounded.Phone,
                    text = phone
                )
                ContactItem(
                    icon = Icons.Rounded.Share,
                    text = social
                )
                ContactItem(
                    icon = Icons.Rounded.Email,
                    text = email
                )
            }
        }
    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(2.dp)
                .background(Color.White.copy(0.2f))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Spacer(modifier = Modifier.width(40.dp))
            Icon(
                imageVector = icon,
                contentDescription = icon.name,
                tint = androidGreen
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = text,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard(
            name = "Lorenzo Vainigli",
            title = "Android Developer",
            phone = "+11 (123) 444 555 666",
            social = "@lorenzovngl",
            email = "lorenzovngl@gmail.com"
        )
    }
}