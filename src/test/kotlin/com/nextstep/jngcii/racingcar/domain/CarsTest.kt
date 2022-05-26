package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CarsTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun `특정 거리만큼 간 차들 확인 테스트`(carA: Car, carB: Car, carC: Car, distance: Int, expected: List<String>) {
        val cars = Cars(carA, carB, carC)

        Assertions.assertThat(cars.getNames(distance)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun arguments() = listOf(
            Arguments.of(
                Car(name = "A", advantage = 1),
                Car(name = "B", advantage = 2),
                Car(name = "C", advantage = 3),
                3,
                listOf("C")
            ),
            Arguments.of(
                Car(name = "A", advantage = 2),
                Car(name = "B", advantage = 1),
                Car(name = "C", advantage = 2),
                2,
                listOf("A", "C")
            ),
            Arguments.of(
                Car(name = "A", advantage = 1),
                Car(name = "B", advantage = 1),
                Car(name = "C", advantage = 1),
                1,
                listOf("A", "B", "C")
            ),
        )
    }
}
