package com.example.loginui.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginui.R
import com.example.loginui.ui.theme.lightGray

@Composable
fun RoundIcon(
    modifier: Modifier = Modifier,
    ImgResource: Int

) {
    Surface(modifier = Modifier, shape = RoundedCornerShape(50.dp)) {
        Image(
            modifier = Modifier.size(40.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = ImgResource), contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun IconCompination() {
    Row(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RoundIcon(ImgResource = R.drawable.flag, modifier = Modifier.size(30.dp))
        Icon(imageVector = Icons.Default.ArrowDropDown, modifier = Modifier.size(40.dp), contentDescription = "flag")
    }
}

@Composable
fun ButtonSurfacePhoneNumber(
    myText: String = "Phone number",
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier.padding(2.dp),
        color = Color.White,
        shape = RoundedCornerShape(50.dp),
        elevation = 2.dp
    ) {
        Text(
            text = myText,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp, bottom = 2.dp, end = 7.dp, top = 2.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonSurface() {
    Surface(modifier = Modifier.fillMaxWidth().height(50.dp), shape = RoundedCornerShape(60.dp), color = lightGray) {
        Row(
            modifier = Modifier.padding(start = 10.dp, top = 1.dp, bottom = 1.dp, end = 3.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Email",
                fontSize = 13.sp,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(end = 10.dp)
            )
            ButtonSurfacePhoneNumber()
        }
    }
}

@Composable
fun OutlinedButton(
    modifier: Modifier = Modifier,
    ImgResource: Int,
    text: String
) {
    Surface(
        border = BorderStroke(1.dp, color = Color.LightGray),
        modifier = Modifier.fillMaxWidth().heightIn(60.dp),
        shape = RoundedCornerShape(50.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundIcon(Modifier.padding(start = 15.dp),ImgResource = ImgResource)
            Spacer(modifier = Modifier.size(6.dp))
            Text(text = text, modifier = Modifier.padding(end = 15.dp))
        }
    }
}

