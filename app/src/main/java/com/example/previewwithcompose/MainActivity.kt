package com.example.previewwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.previewwithcompose.ui.theme.PreviewwithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewwithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) }
    ) {
        Text("I've been clicked $count times")
    }
}

// プレビューにタグ付け
@Preview(name = "Greeting")
@Composable
fun GreetingPreview() {
    PreviewwithComposeTheme {
        Greeting("Android")
    }
}

// プレビューにタグ付け
@Preview(name = "LongGreeting")
@Composable
fun LongGreetingPreview() {
    PreviewwithComposeTheme {
        Greeting(
            "my valued friend, whom I am incapable of "
                    + "greeting without using a great many words"
        )
    }
}

// インタラクティブ プレビュー
@Preview
@Composable
fun PreviewCounter() {
    val counterState = remember { mutableStateOf(0) }

    Counter(
        count = counterState.value,
        updateCount = { newCount ->
            counterState.value = newCount
        }
    )
}
