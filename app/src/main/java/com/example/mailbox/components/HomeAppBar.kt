package com.example.mailbox.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mailbox.MailBoxApp
import com.example.mailbox.ui.theme.MailBoxTheme
import com.example.mailbox.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
// scaffoldState is used since the scaffold will hve to contain the drawer and both are connected
// and we need scaffoldState to open or close the drawer
fun HomeAppBar(scaffoldState: ScaffoldState, scope:CoroutineScope,
               openDialog : MutableState<Boolean>){
    Box(modifier = Modifier.padding(10.dp)){

        Card(elevation = 7.dp , shape = RoundedCornerShape(12.dp), modifier = Modifier.requiredHeight(50.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)) {


IconButton(onClick =  {
scope.launch{
    scaffoldState.drawerState.open()
}
}){ Icon(Icons.Default.Menu , "Menu") }

                Text(text = "Search", modifier = Modifier.weight(2.0f))
                Image(painter = painterResource(id = R.drawable.panda),contentDescription = "Profile",
                modifier = Modifier
                    .size(
                        30.dp
                    )
                    .clip(CircleShape)
                    .clickable {
                        openDialog.value = true
                  // just open it
                    },
                    contentScale = ContentScale.Crop
                    )

if (openDialog.value){
    AccountsDialog(openDialog)

}

            
            
            }

        }


    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MailBoxTheme {
        MailBoxApp()
    }
}