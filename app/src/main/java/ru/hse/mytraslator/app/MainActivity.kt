package ru.hse.mytraslator.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import ru.hse.mytraslator.app.ui.theme.MyTraslatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTraslatorAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar()
                    }
                ) { innerPadding ->

                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primarySurface,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    ImageVector.vectorResource(id = R.drawable.ic_chat),
                    contentDescription = stringResource(R.string.bottom_nav_chat)
                )
            },
            selected = false,
            onClick = {

            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    ImageVector.vectorResource(id = R.drawable.ic_camera),
                    contentDescription = stringResource(R.string.bottom_nav_camera)
                )
            },
            selected = false,
            onClick = {

            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    ImageVector.vectorResource(id = R.drawable.ic_translate_fg),
                    contentDescription = stringResource(R.string.bottom_nav_translate)
                )
            },
            selected = false,
            onClick = {

            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    ImageVector.vectorResource(id = R.drawable.ic_history),
                    contentDescription = stringResource(R.string.bottom_nav_history)
                )
            },
            selected = false,
            onClick = {

            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    ImageVector.vectorResource(id = R.drawable.ic_fav),
                    contentDescription = stringResource(R.string.bottom_nav_fav)
                )
            },
            selected = false,
            onClick = {

            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTraslatorAppTheme {

    }
}