package com.virtualstudios.cmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
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
import cmp.composeapp.generated.resources.don_t_have_an_account
import cmp.composeapp.generated.resources.email
import cmp.composeapp.generated.resources.email_hint
import cmp.composeapp.generated.resources.forgot_password
import cmp.composeapp.generated.resources.login_to_your_account
import cmp.composeapp.generated.resources.login_uppercase
import cmp.composeapp.generated.resources.password
import cmp.composeapp.generated.resources.password_hint
import cmp.composeapp.generated.resources.poppins_medium
import cmp.composeapp.generated.resources.poppins_regular
import cmp.composeapp.generated.resources.sign_up
import cmp.composeapp.generated.resources.visibility
import cmp.composeapp.generated.resources.visibility_off
import cmp.composeapp.generated.resources.welcome_back
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen(
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            TitleText(
                text = stringResource(Res.string.welcome_back),
                modifier = Modifier,
                fontSize = 32.sp
            )

            Text(
                text = stringResource(Res.string.login_to_your_account),
                fontFamily = FontFamily(
                    Font(
                        resource = Res.font.poppins_regular
                    )
                ),
                fontSize = 16.sp,
                color = MaterialTheme.colors.secondaryVariant,
            )

            EmailInputCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            )

            PasswordInputCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )

            ForgotPasswordButton(
                modifier = Modifier.align(
                    Alignment.End
                )
            )

            LoginButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            )

            SignupButton(
                onRegisterClick = onRegisterClick,
                modifier = Modifier
                    .align(Alignment.End)
                //.padding(top = 24.dp)
            )
        }
    }
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
                painter = painterResource(Res.drawable.email),
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface
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
                    tint = MaterialTheme.colors.onSurface
                )
            }

        }
    )
}

@Composable
fun ForgotPasswordButton(modifier: Modifier = Modifier) {
    TextButton(
        onClick = {},
        modifier = modifier
    ) {
        Text(
            text = stringResource(Res.string.forgot_password),
            fontSize = 16.sp,
            color = MaterialTheme.colors.primary,
            fontFamily = FontFamily(
                Font(
                    resource = Res.font.poppins_medium
                )
            ),
        )
    }
}

@Composable
fun LoginButton(
    modifier: Modifier = Modifier
) {

    Button(
        text = stringResource(Res.string.login_uppercase),
        onClick = {},
        modifier = modifier
    )
}

@Composable
fun SignupButton(
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    TextButton(
        onClick = onRegisterClick,
        modifier = modifier
    ) {
        Text(
            buildAnnotatedString {
                append(stringResource(Res.string.don_t_have_an_account))
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                ){
                    append(stringResource(Res.string.sign_up))
                }
            },
            fontSize = 15.sp,
            color = MaterialTheme.colors.secondaryVariant,
            fontFamily = FontFamily(
                Font(
                    resource = Res.font.poppins_medium
                )
            )
        )
    }

}