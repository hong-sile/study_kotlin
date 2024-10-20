package basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test

class ExpressionTest {

    @Test
    fun expressionFuncTestSumTwo() {
        val result: Int = 10.sum(b = 20)

        assertThat(result)
            .isEqualTo(30)
    }

    @Test
    fun expressionFuncTestSumCollections() {
        val result: Int = sum(numbers = listOf(1, 2, 3, 4))

        assertThat(result)
            .isEqualTo(10)
    }

    @ParameterizedTest
    @CsvSource("1, 2", "2, 2", "4, 4")
    fun ifExpression(a: Int, expected: Int) {
        val b = 2

        val max = if (a > b) {
            a
        } else {
            b
        }

        assertThat(max)
            .isEqualTo(expected)
    }

    @Test
    fun forLoop() {
        val expected = 55
        var sum = 0
        for (i in 1..10) {
            sum += i
        }
        assertThat(sum)
            .isEqualTo(expected)
    }

    @Test
    fun forLoopWithStep() {
        val expected = 25
        var sum = 0
        for (i in 1..10 step 2) {
            sum += i
        }
        assertThat(sum)
            .isEqualTo(expected)
    }

    @Test
    fun forLoopWithDownTo() {
        val expected = 55
        var sum = 0
        for (i in 10 downTo 1) {
            sum += i
        }
        assertThat(sum)
            .isEqualTo(expected)
    }

    @Test
    fun forLoopWithDownToAndStep() {
        val expected = 30
        var sum = 0
        for (i in 10 downTo 1 step 2) {
            sum += i
        }
        assertThat(sum)
            .isEqualTo(expected)
    }


    @Test
    fun forLoopWithList() {
        val expected = 15
        var sum = 0
        for (i in listOf(1, 1, 1, 1, 1, 1).indices) {
            sum += i
        }
        assertThat(sum)
            .isEqualTo(expected)
    }

    /*
    ? intellij 가 이렇게 바꿔줬는데 이건 뭘까..?
    함수 정의에 함수를 쓰네
     */
    private fun Int.sum(b: Int): Int {
        return this + b
    }

    private fun sum(numbers: List<Int>): Int {
        return numbers.stream()
            .reduce(0) { x, y -> x + y }
    }

    @Test
    fun testInlineFunction() {
        val result = inlineFunc("10") { str ->
            str.toInt()
        }

        assertThat(result)
            .isEqualTo(10)
    }

    inline fun inlineFunc(numberString: String, lambdaFunc: (String) -> Int): Int {
        return lambdaFunc(numberString)
    }

    @Test
    fun infixAnd() {
        val a = 15
        val b = 12
        val c = 11

        val result1 = (a > b).and(a > c)
        val result2 = (a > b) and (a > c)

        assertAll(
            { assertThat(result1).isTrue() },
            { assertThat(result2).isTrue() }
        )
    }

    @Test
    fun infixShr() {
        val a = 8

        val result1 = a shr 2
        val result2 = a.shr(1)

        assertAll(
            { assertThat(result1).isEqualTo(2) },
            { assertThat(result2).isEqualTo(4) }
        )
    }

    @Test
    fun testUserInfix() {
        val userInFix = UserInFix()

        val result = userInFix.square(10)

        assertThat(result)
            .isEqualTo(100)
    }

    class UserInFix {
        infix fun square(a: Int): Int {
            return a * a
        }
    }
}