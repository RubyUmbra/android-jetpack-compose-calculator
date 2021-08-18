package com.rubyumbra.calculator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.res.stringResource

enum class InputToken(val id: Int, val inExpression: String) {
    Clear(R.string.btn_clear, ""),
    Backspace(R.string.btn_backspace, ""),
    Dot(R.string.btn_dot, "."),
    Divide(R.string.btn_divide, "/"),

    Seven(R.string.btn_7, "7"),
    Eight(R.string.btn_8, "8"),
    Nine(R.string.btn_9, "9"),
    Times(R.string.btn_times, "*"),

    Four(R.string.btn_4, "4"),
    Five(R.string.btn_5, "5"),
    Six(R.string.btn_6, "6"),
    Minus(R.string.btn_minus, "-"),

    One(R.string.btn_1, "1"),
    Two(R.string.btn_2, "2"),
    Three(R.string.btn_3, "3"),
    Plus(R.string.btn_plus, "+"),

    LB(R.string.btn_lb, "("),
    Zero(R.string.btn_0, "0"),
    RB(R.string.btn_rb, ")"),
    Solve(R.string.btn_solve, "=");

    val digits by lazy { listOf(Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine) }
}

@Composable
fun SnapshotStateList<InputToken>.toScreenString(): String =
    buildString { this@toScreenString.forEach { append(stringResource(it.id)) } }

fun SnapshotStateList<InputToken>.toExpressionString(): String =
    joinToString("", transform = InputToken::inExpression)
