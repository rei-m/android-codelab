package me.reim.jetpackcomposebasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.compose.Composable
import androidx.compose.Model

import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.layout.Spacing
import androidx.ui.layout.WidthSpacer
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

// ComposableアノテーションをつけるとUIを返すFunctionになる
// androidx.compose.XXX がコンパイラとランタイム
// androidx.ui.XXX がコンポーネント作る系のライブラリ
// コンポーネントはSingle Responsibility Principle（単一責任の原則）を意識する
// 子コンポーネントは必ず親からデータをもらう
// ModelアノテーションをつけたクラスをComposableの引数に渡してModelのプロパティが変化すると再描画される
// setStateっぽい動き


data class Item(val name: String, val description: String)

@Model
class CounterState(var count: Int = 0)

@Composable
fun MyApp(child: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.Yellow) {
            child()
        }
    }
}

@Composable
fun Counter(state: CounterState) {
    Button(
        text = "I've been clicked ${state.count} times",
        onClick = {
            state.count++
        }
    )
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there"), counterState: CounterState = CounterState()) {
    Column {
        names.forEach { name ->
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, height = 32.dp)
        Counter(counterState)
    }
}

@Composable
fun Greeting(name: String) {
    Text (text = "Hello $name!", modifier = Spacing(24.dp))
}

@Composable
fun MyExampleFunction(items: List<Item>, onSelected: (Item) -> Unit) {
    Column {
        for (item in items) {
            RenderItem(item = item, onClick = { onSelected(item) })
        }
    }
}

@Composable
fun RenderItem(item: Item, onClick: () -> Unit) {
    Clickable(onClick = onClick) {
        Row {
            Text(text = item.name)
            WidthSpacer(4.dp)
            Text(text = item.description)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}