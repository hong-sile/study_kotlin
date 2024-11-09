package com.api.service

import com.api.repository.CouponRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

@SpringBootTest
class ApplyServiceTest {
    @Autowired
    private lateinit var couponRepository: CouponRepository

    @Autowired
    private lateinit var applyService: ApplyService

    @Test
    fun 한번만_응모() {
        applyService.apply(1)

        val count = couponRepository.count()

        assertThat(count).isEqualTo(1)
    }

    @Test
    fun 여러번_응모() {
        val threadCount = 1000
        val executors = Executors.newFixedThreadPool(32)
        // 다른 스레드가 해당 값을 감소시킬 수 있도록 함
        val countDownLatch = CountDownLatch(threadCount)

        for (i in 1L..threadCount) {
            val userId = i
            executors.submit {
                try {
                    applyService.apply(userId = userId)
                }finally {
                    countDownLatch.countDown()
                }
            }
        }

        //countdownlatch가 0이 될 떄까지 메인스레드는 대기한다.
        countDownLatch.await()

        Thread.sleep(10000)

        val couponCount = couponRepository.count()
        assertThat(couponCount).isEqualTo(100)
    }
}