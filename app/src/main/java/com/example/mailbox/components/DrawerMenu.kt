package com.example.mailbox.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mailbox.model.DrawerMenuData

@Composable
fun DrawerMenu(scrollState: ScrollState) { // drawermenu has to get the info

    val menuList = listOf(
        DrawerMenuData.AllInboxes,

        DrawerMenuData.Divider,
        DrawerMenuData.Primary,
        DrawerMenuData.Social,
        DrawerMenuData.Promotions,
        DrawerMenuData.HeaderOne,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Important,
        DrawerMenuData.Sent,
        DrawerMenuData.Schedule,
        DrawerMenuData.Outbox,
        DrawerMenuData.Draft,
        DrawerMenuData.AllMail,
        DrawerMenuData.HeaderTwo,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,
        DrawerMenuData.Divider,
        DrawerMenuData.Setting,
        DrawerMenuData.Help

    )




    Column(Modifier.verticalScroll(scrollState)) {


        Text(text = "MailBox",
            color = Color.Red,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontSize = 20.sp,// fontsize should be in SP and not dp
            fontWeight = FontWeight.Bold)
        menuList.forEach { item ->
            when {
                item.isDivider -> {
                    Divider(modifier = Modifier.padding(bottom = 20.dp, top = 20.dp))
                    // Divider - for using the divider

                }
                item.isHeader -> {
                    Text(text = item.title!!, fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(start = 20.dp, bottom = 20.dp,
                            top = 20.dp))

                }

                else -> {
// here in this case we use the row which has image and the text
                    com.example.mailbox.components.MailDrawerItem(item = item)
                    // passing item from the menulist in the MailDrawerItem below }
                }
            }
        }
    }


}



@Composable
fun MailDrawerItem(item: DrawerMenuData){
    // item of type DrawerMenuData
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 16.dp)
    )

    {
        Image(imageVector = item.icon!!,

            contentDescription = item.title!!,
            modifier = Modifier.weight(1.0f),
            colorFilter = ColorFilter.tint(Color.White)
        // Helps in changing color of icons to white



        )

        Text(text = item.title, modifier = Modifier.weight(4.0f))// takes 80% if the weight

    }}