package com.example.abhayada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.abhayada.ui.theme.AbhayadaTheme
import com.example.abhayada.ui.AuthPage
import com.example.abhayada.ui.HomeFemale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AbhayadaTheme {
                Surface {
                    AppNavHost(navController = rememberNavController())
                }
            }
        }
    }
}


@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = "login"){
    NavHost(navController = navController,
        startDestination = startDestination,

        exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(500, easing = EaseInOut)) },

        popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(500, easing = EaseInOut))}
    ) {
        composable("login") { AuthPage(navController) }
        composable("female") { HomeFemale(navController) }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AbhayadaTheme {

    }
}