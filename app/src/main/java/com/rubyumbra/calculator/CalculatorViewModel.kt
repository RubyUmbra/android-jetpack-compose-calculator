package com.rubyumbra.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.rubyumbra.calculator.InputToken.*
import org.mariuszgromada.math.mxparser.Expression

class CalculatorViewModel : ViewModel() {
    var expr = mutableStateListOf<InputToken>()
        private set
    var result by mutableStateOf<Double?>(null)
        private set
    private var balance by mutableStateOf(0)

    private fun pushDigit(input: InputToken) {
        if (result != null)
            clear()
        if (expr.isNotEmpty() && expr.last() == RB)
            return
        expr += input
    }

    private fun pushLB() {
        if (result != null)
            clear()
        if (expr.isNotEmpty() && expr.last() == RB)
            return
        expr += LB
        balance += 1
    }

    private fun pushRB() {
        if (result != null)
            clear()
        if (balance <= 0)
            return
        if (expr.isNotEmpty() && expr.last() != RB && expr.last() !in Divide.digits)
            return
        expr += RB
        balance -= 1
    }

    private fun pushPlusMinus(input: InputToken) {
        if (result != null)
            clear()
        expr += input
    }

    private fun pushBinOpFirstPriority(input: InputToken) {
        if (result != null)
            clear()
        if (expr.isEmpty())
            return
        if (expr.last() != RB && expr.last() !in Divide.digits)
            return
        expr += input
    }

    private fun pop() {
        if (result != null)
            return
        if (expr.isEmpty())
            return
        when (expr.last()) {
            Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Dot -> expr.removeLast()
            Plus, Minus, Times, Divide -> expr.removeLast()
            LB -> {
                expr.removeLast()
                balance -= 1
            }
            RB -> {
                expr.removeLast()
                balance += 1
            }
            else -> Unit
        }
    }

    private fun clear() {
        expr.clear()
        result = null
        balance = 0
    }

    private fun solve() {
        if (result != null)
            return
        if (expr.isEmpty())
            return
        if (balance > 0 && expr.last() != RB && expr.last() !in Divide.digits)
            return
        while (balance > 0) {
            expr += RB
            balance -= 1
        }
        result = Expression(expr.toExpressionString()).calculate()
    }

    fun update(input: InputToken): Unit = when (input) {
        Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Dot -> pushDigit(input)

        LB -> pushLB()
        RB -> pushRB()

        Plus, Minus -> pushPlusMinus(input)
        Times, Divide -> pushBinOpFirstPriority(input)

        Backspace -> pop()
        Clear -> clear()
        Solve -> solve()
    }
}
