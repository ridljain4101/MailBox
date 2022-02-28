package com.example.mailbox.components
// Lazy Columns
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mailbox.mailList
import com.example.mailbox.model.MailData


@Composable
// create maillist
fun MailList(
    paddingValues: PaddingValues,
    scrollState: ScrollState
){// Box helps is putting a lot of data in one place

Box(modifier = Modifier.padding(paddingValues))
{
    LazyColumn(

        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .scrollable(scrollState,Orientation.Vertical)
    //** here we use the scrollState created above for the avoid of FAB confusion
    //**and we will scroll vertically
    //** does not make a difference but helps in the proper usage of the FAB

    ){

        // passing data of items to the mailing list(inside lazy column)
//*** we get the items from our data source -mailList
//** here data source is mailList

        items(mailList){
mailData ->
    MailItem(mailData = mailData  )
}
        }




}


}




@Composable
// define individual items and pass data through those items - to define how such an item looks like
fun MailItem(mailData:MailData,modifier: Modifier = Modifier) {
// item of type MailData

    Row(
modifier = Modifier
    .fillMaxWidth()
    .padding(bottom = 8.dp)
    ) {

        Card(modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape),
            backgroundColor = Color.Gray)
        {
            Text(text = mailData.userName[0].toString(),
                textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp))
        }

        Column(modifier.weight(2.0f)) {// we make a property weight since we have 3 texts which will use them

            Text(text = mailData.userName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)



            Text(text = mailData.subject,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold)



            Text(
                text = mailData.body,
                fontSize = 13.sp,
            )

        }


        Column {
            Text(text = mailData.timeStamp)
            IconButton(onClick = { }, // Iconbutton so that it is clickable

                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 15.dp)
            ) {
                Icon(imageVector = Icons.Outlined.StarOutline, "")
            }

        }


    }
}


@Preview(showBackground = true)
@Composable
fun MailItemPreview(){
MailItem(mailData = MailData(
    mailId = 5,
    userName = "Ridly",
    subject = "Important Announcement",
    body = "Hope this mail finds you well",
    timeStamp = "18.46"

))
}