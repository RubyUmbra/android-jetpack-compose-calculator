package com.rubyumbra.calculator.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rubyumbra.calculator.CalculatorViewModel
import com.rubyumbra.calculator.toScreenString

@Composable
fun ColumnScope.Display(cvm: CalculatorViewModel = viewModel()) = Column(
    modifier = Modifier
        .weight(3f)
        .fillMaxSize()
) {
    Row(
        modifier = Modifier
            .weight(3f)
            .fillMaxSize()
    ) {
        Text(
            text = cvm.expr.toScreenString(),
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterVertically),
        )
    }
    Row(
        modifier = Modifier
            .weight(1f)
            .fillMaxSize()
    ) {
        val res = cvm.result
        Text(
            text = if (res != null) "= $res" else "",
            fontSize = 20.sp,
            maxLines = 1,
            modifier = Modifier.align(Alignment.CenterVertically),
        )
    }
}
