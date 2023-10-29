package comleifandersen.aashish.easybutton

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import comleifandersen.aashish.easybutton.ui.theme.EasyButtonTheme

class MainActivity : ComponentActivity() {
    private lateinit var mp: MediaPlayer;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }

        this.mp = MediaPlayer.create(applicationContext, R.raw.easy)
        setContentView(R.layout.easy_button_layout)
        (findViewById<View>(R.id.easy_button_layout) as ImageButton).setOnClickListener {
            this@MainActivity.mp.release()
            this@MainActivity.mp = MediaPlayer.create(this@MainActivity.applicationContext, R.raw.easy)
            this@MainActivity.mp.start()
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EasyButtonTheme {
        Greeting("Android")
    }
}
