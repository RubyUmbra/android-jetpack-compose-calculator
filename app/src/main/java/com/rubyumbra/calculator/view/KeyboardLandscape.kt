package com.rubyumbra.calculator.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rubyumbra.calculator.InputToken

@Composable
fun ColumnScope.KeyboardLandscape() = Column(
    modifier = Modifier
        .weight(4f)
        .fillMaxSize()
) {
    CRow {
        CButton(InputToken.Seven)
        CButton(InputToken.Eight)
        CButton(InputToken.Nine)
        CButton(InputToken.Clear)
        CButton(InputToken.Backspace)
    }
    CRow {
        CButton(InputToken.Four)
        CButton(InputToken.Five)
        CButton(InputToken.Six)
        CButton(InputToken.Plus)
        CButton(InputToken.Minus)
    }
    CRow {
        CButton(InputToken.One)
        CButton(InputToken.Two)
        CButton(InputToken.Three)
        CButton(InputToken.Times)
        CButton(InputToken.Divide)
    }
    CRow {
        CButton(InputToken.LB)
        CButton(InputToken.Zero)
        CButton(InputToken.RB)
        CButton(InputToken.Dot)
        CButton(InputToken.Solve)
    }
}
