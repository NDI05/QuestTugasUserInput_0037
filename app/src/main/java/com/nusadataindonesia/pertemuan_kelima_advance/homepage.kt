package com.nusadataindonesia.pertemuan_kelima_advance

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Batal")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun page(modifier: Modifier){
    var textNamaDepan by remember { mutableStateOf("") }
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textTglLahir by remember { mutableStateOf("") }
    var textExperince by remember { mutableStateOf("") }
    var textSkill by remember { mutableStateOf("") }

    var email by remember { mutableStateOf("") }
    var NamaDepan by remember { mutableStateOf("") }
    var NamaBelakang by remember { mutableStateOf("") }
    var TglLahir by remember { mutableStateOf("") }
    var selectedExperince by remember { mutableStateOf("") }
    var selectedSkill by remember { mutableStateOf("") }

    var tampilkanModal by remember { mutableStateOf(false) }
    var expandedDropdown by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val skill = listOf<String>("Web Dev", "Mobile Dev", "AI Dev")
    val experience = listOf<String>("Junior", "Senior")
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.bg),
            contentDescription = null,
            modifier=modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(top = 300.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp))
                .background(color = Color.White)
                .padding(
                    vertical = dimensionResource(R.dimen.padding_medium),
                    horizontal = dimensionResource(R.dimen.padding_medium)
                ),
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(40.dp)),
            ) {
                Column(
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = dimensionResource(R.dimen.padding_xl),
                            horizontal = dimensionResource(R.dimen.padding_xl)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        stringResource(R.string.judul),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Black
                    )
                    Text(
                        stringResource(R.string.subJudul),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Row(
                        modifier= Modifier
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = textNamaDepan,
                            onValueChange = { textNamaDepan = it },
                            label = {Text(stringResource(R.string.labelNamaDepan))},
                            modifier= modifier
                                .weight(1f),
                            shape = MaterialTheme.shapes.large
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        OutlinedTextField(
                            value = textNamaBelakang,
                            onValueChange = { textNamaBelakang = it },
                            label = {Text(stringResource(R.string.labelNamaBelakang))},
                            modifier= modifier
                                .weight(1f),
                            shape = MaterialTheme.shapes.large
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = textEmail,
                        onValueChange = { textEmail = it },
                        label = {Text(stringResource(R.string.labelEmail))},
                        modifier = modifier
                            .fillMaxWidth(),
                        shape = MaterialTheme.shapes.large
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier= Modifier
                            .fillMaxWidth()
                    ) {
                        Box(
                            modifier = modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = textTglLahir,
                                onValueChange = {},
                                readOnly = true,
                                enabled = true,
                                label = { Text(stringResource(R.string.labelTglLahir)) },
                                modifier = Modifier.fillMaxWidth(),
                                shape = MaterialTheme.shapes.large
                            )
                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .clickable { tampilkanModal = true }
                            )
                        }
                        if (tampilkanModal) {
                            DatePickerModal(
                                onDateSelected = { milidetik ->
                                    if (milidetik != null) {
                                        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                                        textTglLahir = formatter.format(Date(milidetik))
                                    }
                                },
                                onDismiss = { tampilkanModal = false }
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedDropdown,
                            onExpandedChange = {expandedDropdown = !expandedDropdown},
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = textExperince,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text(stringResource(R.string.labelExperience)) },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDropdown)
                                },
                                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .menuAnchor(),
                                shape = MaterialTheme.shapes.large
                            )
                            ExposedDropdownMenu(
                                expanded = expandedDropdown,
                                onDismissRequest = { expandedDropdown = false }
                            ) {
                                experience.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(item) },
                                        onClick = {
                                            textExperince = item
                                            expandedDropdown = false
                                        },
                                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            stringResource(R.string.labelSkill),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            skill.forEach { item ->
                                Row(
                                    modifier = Modifier
                                        .selectable(
                                            selected = textSkill == item,
                                            onClick = {textSkill = item}
                                        ),
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    RadioButton(
                                        selected = textSkill == item,
                                        onClick = {textSkill = item}
                                    )
                                    Text(item)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Button(
                            onClick = {
                                NamaDepan = textNamaDepan
                                NamaBelakang = textNamaBelakang
                                TglLahir = textTglLahir
                                selectedSkill = textSkill
                                selectedExperince = textExperince
                                email = textEmail

                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Data Terdaftar: $NamaDepan $NamaBelakang | $email | $selectedExperince | $selectedSkill"
                                    )
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                stringResource(R.string.proced),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }


        }
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
    }
}