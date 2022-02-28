package com.example.mailbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.mailbox.components.*
import com.example.mailbox.components.DrawerMenu
import com.example.mailbox.ui.theme.MailBoxTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MailBoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MailBoxApp()
                }
            }
        }
    }
}

@Composable
fun MailBoxApp() {

    val scaffoldState = rememberScaffoldState()
val coroutineScope = rememberCoroutineScope()
val scrollState = rememberScrollState()
val openDialogue = remember{
    mutableStateOf(false)
}



//**Scaffold -layout that provides  a lot of design elements
 Scaffold(scaffoldState = scaffoldState, // to make scaffold aware of the creation of sccaffoldState
     topBar ={ HomeAppBar(scaffoldState, coroutineScope, openDialogue)},
     drawerContent = {
DrawerMenu(scrollState = scrollState)
         // whenever we create this drawer menu or have to pass the scrollState in it
     },

bottomBar ={
HomeBottomMenu()
},
     floatingActionButton = { MailBoxFAB(scrollState) }
// here

 )


 {
MailList(paddingValues = it,scrollState)
 }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MailBoxTheme {
      MailBoxApp()
    }
}