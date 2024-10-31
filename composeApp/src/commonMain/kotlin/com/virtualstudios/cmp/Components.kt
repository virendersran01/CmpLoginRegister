package com.virtualstudios.cmp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmp.composeapp.generated.resources.Res
import cmp.composeapp.generated.resources.poppins_medium
import cmp.composeapp.generated.resources.poppins_regular
import cmp.composeapp.generated.resources.poppins_semi_bold
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ),
) {
    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        colors = colors
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(
                Font(
                    resource = Res.font.poppins_semi_bold
                )
            ),
            fontSize = 18.sp,
        )
    }
}


@Composable
fun InputCard(
    title: String,
    inputHint: String,
    inputText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    isError: Boolean = false,
    errorMessage: String = "",
    trailingIcon: @Composable (() -> Unit)? = null,
) {

    Card(
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface
        ),
        modifier = modifier
//            .padding(
//                top = 12.dp,
//                bottom = 12.dp
//            )
    ) {

        InputFieldTitle(
            text = title,
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    top = 8.dp
                )
                .fillMaxWidth()
        )

        TextField(
            value = inputText,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = inputHint,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontFamily = FontFamily(
                        Font(
                            resource = Res.font.poppins_regular
                        )
                    ),
                    fontSize = 16.sp
                )
            },
            trailingIcon = trailingIcon,
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(
                fontFamily = FontFamily(
                    Font(
                        resource = Res.font.poppins_regular
                    )
                ),
                fontSize = 16.sp
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
                unfocusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.inverseOnSurface,
                focusedIndicatorColor = MaterialTheme.colorScheme.inverseOnSurface,
                cursorColor = MaterialTheme.colorScheme.inverseOnSurface
            ),
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            keyboardActions = keyboardActions
        )


    }

}

@Preview
@Composable
private fun HeaderTextPreview() {
    Surface {
        HeaderText(
            "Android"
        )
    }
}

@Composable
fun HeaderText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
) {

    Text(
        text = text,
        color = color,
        fontFamily = MaterialTheme.typography.headlineLarge.fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    fontSize: TextUnit = 20.sp,
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = fontSize,
        color = color,
        fontFamily = FontFamily(
            Font(
                resource = Res.font.poppins_semi_bold
            )
        )
    )
}

@Composable
fun InputFieldTitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
) {
    Text(
        text = text,
        color = color,
        fontFamily = FontFamily(
            Font(
                resource = Res.font.poppins_medium
            )
        ),
        fontSize = 18.sp,
        modifier = modifier
    )
}
