package com.example.mailbox.components

import androidx.compose.foundation.ScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun MailBoxFAB(scrollState: ScrollState) {


    if (scrollState.value > 70) {
        ExtendedFloatingActionButton(

            text = {
                Text(text = "Compose", fontSize = 16.sp)
// here we still used the compose Text since we needed to change the size of the font


            }, onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "") },
            backgroundColor = Color.Gray

        )
    }
    else {

        FloatingActionButton(onClick = { /*TODO*/ },
            backgroundColor = Color.Gray
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")

        }
    }
}