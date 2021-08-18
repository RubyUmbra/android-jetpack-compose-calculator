package com.rubyumbra.calculator.view

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ColumnScope.CRow(content: @Composable RowScope.() -> Unit) = Row(
    modifier = Modifier
        .weight(1f)
        .fillMaxSize(),
    content = content,
)
