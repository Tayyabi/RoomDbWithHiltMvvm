package com.xyron.roomdbwithhiltmvvm.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xyron.roomdbwithhiltmvvm.Contact
import com.xyron.roomdbwithhiltmvvm.viewmodels.ContactViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactDialog(
    contactViewModel: ContactViewModel,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {

    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    var phoneNumber by remember {
        mutableStateOf("")
    }

    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
                           onDismiss()
        },
        confirmButton = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {
                    contactViewModel.saveContact(firstName, lastName,phoneNumber)
                }) {
                    Text(text = "Save")
                }
            }
        },
        title = { Text(text = "Add Contact") },
        text = {

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = firstName,
                    onValueChange = {
                        firstName = it
                    },
                    placeholder = {
                        Text(text = "First name")
                    }
                )

                TextField(
                    value = lastName,
                    onValueChange = {
                        lastName = it
                    },
                    placeholder = {
                        Text(text = "Last name")
                    }
                )

                TextField(
                    value = phoneNumber,
                    onValueChange = {
                        phoneNumber = it
                    },
                    placeholder = {
                        Text(text = "Phone Number")
                    }
                )
            }
        }
    )

}