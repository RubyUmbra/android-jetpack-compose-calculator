package com.rubyumbra.calculator.view

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rubyumbra.calculator.CalculatorViewModel
import com.rubyumbra.calculator.InputToken

@Composable
fun RowScope.CButton(tok: InputToken, cvm: CalculatorViewModel = viewModel()) = Button(
    onClick = { cvm.update(tok) },
    modifier = Modifier
        .padding(1.dp)
        .weight(1f)
        .fillMaxSize(),
    content = {
        Text(
            text = stringResource(tok.id),
            fontSize = 20.sp,
            maxLines = 1,
        )
    },
)
