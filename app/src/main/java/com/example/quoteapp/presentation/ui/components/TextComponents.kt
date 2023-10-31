package com.example.quoteapp.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.quoteapp.presentation.theme.TextColor

@Composable
fun NormalTextComponent(
    value: String,
    modifier: Modifier,
) {
    Text(
        text = value,
        modifier = modifier,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(
    value: String,
    modifier: Modifier,
) {
    Text(
        text = value,
        modifier = modifier,
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotesTextField(
    labelValue: String,
    textValue: String,
    onValueChanged:(String) -> Unit,
    isInputError: Boolean = false,
) {
    val dateTimePickerColors = TextFieldDefaults.outlinedTextFieldColors(
        disabledTextColor = Color.Gray,
        disabledBorderColor = if (isInputError) Color.Red else Color.Gray,
        containerColor = Color.White,
    )
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        value = textValue,
        onValueChange = onValueChanged,
        enabled = true,
        singleLine = true,
        colors = dateTimePickerColors,
        isError = isInputError,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPasswordTextField(
    labelValue: String,
    textValue: String,
    onValueChanged:(String) -> Unit,
    isInputError: Boolean = false,
) {
    val dateTimePickerColors = TextFieldDefaults.outlinedTextFieldColors(
        disabledTextColor = Color.Gray,
        disabledBorderColor = if (isInputError) Color.Red else Color.Gray,
        containerColor = Color.White,
    )
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        value = textValue,
        onValueChange = onValueChanged,
        enabled = true,
        colors = dateTimePickerColors,
        isError = isInputError,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            IconButton(onClick = {
                passwordVisible.value = !passwordVisible.value
            }) {
                Icon(imageVector = iconImage, contentDescription = "")
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun UnderLinesText(
    value: String
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = value,
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}