package com.rubyumbra.calculator.view

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext

@Composable
fun Content() = Scaffold(
    topBar = {
        TopAppBar(
            title = { Text(text = "Calculator") },
            actions = {
                val context = LocalContext.current

                IconButton(
                    onClick = {
                        val text = "Coded by\n" +
                                "Gromov \"RubyUmbra\" Dmitry\n" +
                                "<rubyumbra@gmail.com>\n" +
                                "https://github.com/RubyUmbra"
                        val duration = Toast.LENGTH_LONG

                        Toast.makeText(context, text, duration).show()
                    },
                    content = {
                        Icon(imageVector = Icons.Filled.Info, contentDescription = "")
                    }
                )
            }
        )
    },
    content = {
        Column(modifier = Modifier.fillMaxSize()) {
            Display()
            when (LocalConfiguration.current.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> KeyboardPortrait()
                else -> KeyboardLandscape()
            }
        }
    },
)
