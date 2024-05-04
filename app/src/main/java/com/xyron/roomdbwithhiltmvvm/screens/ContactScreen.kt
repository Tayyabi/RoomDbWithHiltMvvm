package com.xyron.roomdbwithhiltmvvm.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xyron.roomdbwithhiltmvvm.viewmodels.ContactViewModel

@Composable
fun ContactScreen() {

    val contactViewModel: ContactViewModel = hiltViewModel()
    val contacts = contactViewModel.contacts.collectAsState()

    var showDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showDialog = true
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contact")
            }
        },
        modifier = Modifier.padding(16.dp)
    ) { padding ->

        if(showDialog){
            AddContactDialog(contactViewModel, onDismiss = {
                showDialog = false
            })
        }

        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                        Row(
                            modifier = Modifier
                                .clickable {

                                },
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            
                            RadioButton(
                                selected = true,
                                onClick = {

                                }
                            )
                            Text(text = "First name")

                            RadioButton(
                                selected = false,
                                onClick = {

                                }
                            )
                            Text(text = "Last name")

                            RadioButton(
                                selected = false,
                                onClick = {

                                }
                            )
                            Text(text = "Phone number")
                        }
                    }
                }


            items(contacts.value){ contact ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "${contact.firstName} ${contact.lastName}",
                            fontSize = 20.sp
                        )

                        Text(
                            text = contact.phoneNumber,
                            fontSize = 12.sp
                        )
                    }
                    IconButton(onClick = {
                        contactViewModel.deleteContact(contact)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete Contact"
                        )
                    }
                }

            }

        }

    }
}