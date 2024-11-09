package com.api.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CouponTest {

    @Test
    fun coupon을_생성한다() {
        val coupon1 = Coupon(id = 10L, userId = 10L)
        val coupon2 = Coupon(id = 10L, userId = 10L)

        assertThat(coupon1)
            .usingRecursiveComparison()
            .isEqualTo(coupon2)
    }
}
