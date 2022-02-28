package com.example.mailbox.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData (// sealed class - more control over inheritance
     val icon : ImageVector? = null, // can be null in headers/dividers
             val title : String? = null, // can be nulll in dividers
     val isDivider : Boolean =false, // since if Divider no text or image
     val isHeader : Boolean = false // since if header only text

){
    //Todo 12 We create an object for easy access to each of the item
    object AllInboxes: DrawerMenuData(
        icon = Icons.Default.AllInbox,
        title = "All inboxes"
    )
    object Primary: DrawerMenuData(
        icon = Icons.Default.Inbox,
        title = "Primary"
    )
    object Social: DrawerMenuData(
        icon = Icons.Default.Person,
        title = "Social"
    )
    object Promotions: DrawerMenuData(
        icon = Icons.Default.Tag,
        title = "Promotions",
    )
    object Starred: DrawerMenuData(
        icon = Icons.Default.StarOutline,
        title = "Starred"
    )

    object Snoozed: DrawerMenuData(
        icon = Icons.Default.Snooze,
        title = "Snoozed"
    )
    object Important: DrawerMenuData(
        icon = Icons.Default.Label,
        title = "Important"
    )
    object Sent: DrawerMenuData(
        icon = Icons.Default.Send,
        title = "Sent"
    )
    object Schedule: DrawerMenuData(
        icon = Icons.Default.Schedule,
        title = "Scheduled"
    )
    object Outbox: DrawerMenuData(
        icon = Icons.Default.Outbox,
        title = "Outbox"
    )
    object Draft: DrawerMenuData(
        icon = Icons.Default.Drafts,
        title = "Drafts"
    )
    object AllMail: DrawerMenuData(
        icon = Icons.Default.Mail,
        title = "All Mail"
    )
    object Calendar: DrawerMenuData(
        icon = Icons.Default.CalendarToday,
        title = "Calendar"
    )
    object Contacts: DrawerMenuData(
        icon = Icons.Default.Contacts,
        title = "Contacts"
    )
    object Setting: DrawerMenuData(
        icon = Icons.Default.Settings,
        title = "Settings"
    )
    object Help: DrawerMenuData(
        icon = Icons.Default.Help,
        title = "Help & FeedBack"
    )

    //Todo 22 :Create object for divider and headers
    object Divider: DrawerMenuData(
        isDivider = true
    )
    object HeaderOne: DrawerMenuData(
        isHeader = true,
        title = "ALL LABELS"
    )
    object HeaderTwo: DrawerMenuData(
        isHeader = true,
        title = "GOOGLE APPS"
    )
}
