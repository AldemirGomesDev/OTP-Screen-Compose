package br.com.aldemir.otpapplication.ui.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalComposeUiApi
@Composable
fun OtpScreen() {
    val scaffoldState = rememberScaffoldState()
    val _text = remember { mutableStateOf("") }
    val finished = remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    if (finished.value) keyboardController?.hide()
    else keyboardController?.show()

    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                OtpView(
                    otpText = _text.value,
                    onOtpTextChange = { text, isValid ->
                        _text.value = text
                        finished.value = isValid
                    }
                )
            }
        }
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true)
@Composable
private fun OtpViewPreview() {
    OtpScreen()
}