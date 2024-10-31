package com.virtualstudios.cmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmp.composeapp.generated.resources.Res
import cmp.composeapp.generated.resources.already_have_an_account
import cmp.composeapp.generated.resources.create_an_account
import cmp.composeapp.generated.resources.email
import cmp.composeapp.generated.resources.email_hint
import cmp.composeapp.generated.resources.enter_full_name
import cmp.composeapp.generated.resources.full_name
import cmp.composeapp.generated.resources.get_started_uppercase
import cmp.composeapp.generated.resources.login
import cmp.composeapp.generated.resources.password
import cmp.composeapp.generated.resources.password_hint
import cmp.composeapp.generated.resources.phone
import cmp.composeapp.generated.resources.poppins_medium
import cmp.composeapp.generated.resources.poppins_regular
import cmp.composeapp.generated.resources.register_uppercase
import cmp.composeapp.generated.resources.user
import cmp.composeapp.generated.resources.visibility
import cmp.composeapp.generated.resources.visibility_off
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun RegisterScreen(
    onRegister: () -> Unit,
    onLogin: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.surface
            )
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TitleText(
            text = stringResource(Res.string.get_started_uppercase),
            modifier = Modifier.padding(top = 32.dp),
            fontSize = 32.sp
        )

        Text(
            text = stringResource(Res.string.create_an_account),
            fontFamily = FontFamily(
                Font(
                    resource = Res.font.poppins_regular
                )
            ),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        FullNameInputCard(
            modifier = Modifier
                .padding(top = 32.dp)
        )

        EmailInputCard(
            modifier = Modifier
                .padding(top = 24.dp)

        )

        PhoneNumberInputCard(
            modifier = Modifier
                .padding(top = 24.dp)
        )

        PasswordInputCard(
            modifier = Modifier
                .padding(top = 24.dp)
        )

        RegisterButton(
            onRegisterClick = onRegister,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )

        LoginButton(
            onLogin = onLogin,
            modifier = Modifier.align(Alignment.End)
        )
    }

}

@Composable
private fun FullNameInputCard(
    modifier: Modifier = Modifier
) {

    var fullNameInput by remember { mutableStateOf("") }

    InputCard(
        title = stringResource(Res.string.full_name),
        inputHint = stringResource(Res.string.enter_full_name),
        inputText = fullNameInput,
        onValueChange = {
            fullNameInput = it
        },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        trailingIcon = {
            Icon(
                painter = painterResource(Res.drawable.user),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        /*keyboardActions = KeyboardActions(
            onNext = {

            }
        )*/
    )

}

@Composable
private fun EmailInputCard(
    modifier: Modifier = Modifier
) {

    var emailInput by remember { mutableStateOf("") }

    InputCard(
        title = stringResource(Res.string.email),
        inputHint = stringResource(Res.string.email_hint),
        inputText = emailInput,
        onValueChange = {
            emailInput = it
        },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        /*keyboardActions = KeyboardActions(
            onNext = {

            }
        )*/
    )

}

@Composable
private fun PhoneNumberInputCard(
    modifier: Modifier = Modifier
) {

    var phoneNumberInput by remember { mutableStateOf("") }

    InputCard(
        title = "Phone Number",
        inputHint = "Enter phone number",
        inputText = phoneNumberInput,
        onValueChange = {
            phoneNumberInput = it
        },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Next
        ),
        trailingIcon = {
            Icon(
                painter = painterResource(Res.drawable.phone),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        /*keyboardActions = KeyboardActions(
            onNext = {

            }
        )*/
    )

}

@Composable
private fun PasswordInputCard(
    modifier: Modifier = Modifier
) {

    var passwordInput by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    var showPassword by remember { mutableStateOf(false) }
    val visualTransformation = if (showPassword) {
        VisualTransformation.None
    }else{
        PasswordVisualTransformation()
    }

    InputCard(
        title = stringResource(Res.string.password),
        inputHint = stringResource(Res.string.password_hint),
        inputText = passwordInput,
        onValueChange = {
            passwordInput = it
        },
        modifier = modifier,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        trailingIcon = {
            IconButton(
                onClick = {
                    showPassword = !showPassword
                }
            ) {
                Icon(
                    painter = painterResource(
                        if (showPassword)
                            Res.drawable.visibility_off
                        else Res.drawable.visibility
                    ),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

        }
    )

}

@Composable
fun RegisterButton(
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        text = stringResource(Res.string.register_uppercase),
        onClick = onRegisterClick,
        modifier = modifier,
    )
}

@Composable
fun LoginButton(
    onLogin: () -> Unit,
    modifier: Modifier = Modifier,
) {

    TextButton(
        onClick = onLogin,
        modifier = modifier
    ) {
        Text(
            buildAnnotatedString {
                append(stringResource(Res.string.already_have_an_account))
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(stringResource(Res.string.login))
                }
            },
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontFamily = FontFamily(
                Font(
                    resource = Res.font.poppins_medium
                )
            )
        )
    }
}