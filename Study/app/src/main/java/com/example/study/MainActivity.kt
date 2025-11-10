// 10. 상태 호이스팅부터 이어서 시작

package com.example.study

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.study.ui.theme.StudyTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EditNumberField(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EditNumberField(modifier: Modifier = Modifier) {
    var amountInput by remember { mutableStateOf("") }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp),
        horizontalAlignment = Alignment.Start
        ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "Calculate Tip"
        )

        TextField(
            modifier = Modifier.padding(bottom = 10.dp),
            value = amountInput,
            onValueChange = { amountInput = it },
            label = { Text(stringResource(R.string.bill_amount)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EditNumberFieldPreview() {
    StudyTheme {
//        EditNumberField("Android")
        EditNumberField()
    }
}

@Composable
fun TipTimeLayout()
{
    Column()
    {
        Text(
            text = "Tip Amount: $tip",
            fontSize = 24.sp
        )
    }
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
    val tip = tipPercent / 100 * amount

    return NumberFormat.getCurrencyInstance().format(tip)
}