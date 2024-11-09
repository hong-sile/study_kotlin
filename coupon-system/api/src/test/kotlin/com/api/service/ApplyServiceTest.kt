package com.api.service

import com.api.repository.CouponRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApplyServiceTest{
    @Autowired
    private lateinit var couponRepository: CouponRepository
    @Autowired
    private lateinit var applyService: ApplyService

    @Test
    fun 한번만_응모(){
        applyService.apply(1)

        val count = couponRepository.count()

        assertThat(count).isEqualTo(1)
    }
}