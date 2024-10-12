package basic

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class DataTypeTest {

    @Test
    fun arrayTest() {
        val actual = Array(5, { i -> i * i })
        val expected = arrayOf(0, 1, 4, 9, 16)

        assertThat(actual)
            .usingRecursiveComparison()
            .isEqualTo(expected)
    }

    @Test
    fun stringTemplateTest() {
        val value = listOf(10, 20, 30)
        val expected = "10 3"

        assertThat("${value[0]} ${value.size}")
            .isEqualTo(expected)
    }

    @Test
    fun multiLineStringTest() {
        val str = """My
        |name
        |is
        """.trimMargin()
        print(str)
    }

    //Unit
    @Test
    fun lambdaTest() {
        val sumLambda: (Int, Int) -> Int = { a, b -> a + b }
        val consumer: (Int) -> Unit = { a -> print(a) }
        val provider2: () -> Int = { 2 }

        val actual = sumLambda(1, provider2())
        consumer(actual)
        val expected = 3

        assertThat(actual)
            .isEqualTo(expected)
    }

    @Test
    fun lambdaClassExtension(){
        val append : String.(Int) -> String = { this + it }

        val actual = "Test".append(50)
        val expected = "Test50"

        assertThat(actual)
            .isEqualTo(expected)
    }
}