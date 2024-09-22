package com.example.abhayada.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun AuthPage(navController: NavController){

    var aadharNumber by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 40.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(top = 40.dp)) {
                Text(
                    text = "Aadhar",
                    fontSize = 40.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Verification",
                    fontSize = 40.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
            }
            TextField(
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp).border(width = 1.dp, color = Color(0x22000000), shape = RoundedCornerShape(size = 15.dp)).height(59.dp),
                value = aadharNumber,
                onValueChange = {aadharNumber = it},
                placeholder = { Text(text = "XXXX - XXXX - XXXX - XXXX", fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.alpha(0.25f)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium, color = Color(0xaa000000)),
                shape = RoundedCornerShape(size = 15.dp)
            )
            Row(modifier = Modifier.padding(top = 10.dp, start = 5.dp)) {
                RadioButton(selected = false, onClick = null, modifier = Modifier)
                Spacer(modifier = Modifier.size(5.dp))
                Text(text = "Yes, I agree to ", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xaa000000))
                Text(text = "Terms of Service.", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.Blue)
            }
            Box(modifier = Modifier.fillMaxSize().padding(bottom = 30.dp), contentAlignment = Alignment.BottomCenter) {
                Button(onClick = { navController.navigate("female") }, modifier = Modifier.height(55.dp), shape = RoundedCornerShape(size = 15.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xffd9d9d9))) {
                    Text(
                        text = "Send OTP",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xaa000000),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    )
                }
            }
        }
    }
}