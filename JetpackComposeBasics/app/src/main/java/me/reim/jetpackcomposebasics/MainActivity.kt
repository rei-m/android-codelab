package me.reim.jetpackcomposebasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.unaryPlus
import androidx.ui.core.CurrentTextStyleProvider

import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Surface
import androidx.ui.text.TextStyle
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

val green = Color(0xFF1EB980.toInt())
val grey = Color(0xFF26282F.toInt())
private val themeColors = MaterialColors(
    primary = green,
    surface = grey,
    onSurface = Color.White
)

@Composable
fun CustomTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        val textStyle = TextStyle(color = Color.Red)
        CurrentTextStyleProvider(value = textStyle) {
            children()
        }
    }
}


@Composable
fun MyApp(child: @Composable() () -> Unit) {
    CustomTheme {
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
        },
        style = ContainedButtonStyle(color = if (state.count > 5) Color.Green else Color.White)

    )
}

@Composable
fun MyScreenContent(
    names: List<String> = listOf("Android", "there"),
    counterState: CounterState = CounterState()
) {
    Column(modifier = ExpandedHeight, crossAxisAlignment = CrossAxisAlignment.Center) {
        Column(modifier = Flexible(1f), crossAxisAlignment = CrossAxisAlignment.Center) {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
        Counter(counterState)
    }
}

@Composable
fun Greeting(name: String) {
    Text (
        text = "Hello $name!",
        modifier = Spacing(24.dp),
        style = +themeTextStyle { h2 }
    )
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
    MaterialTheme {
        Greeting("Android")
    }
}