package com.api.service

import com.api.producer.CouponCreateProducer
import com.api.repository.CouponCountRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private const val COUPON_MAX_COUNT = 100

@Service
@RequiredArgsConstructor
class ApplyService(
    private val couponCountRepository: CouponCountRepository,
    private val couponCreateProducer: CouponCreateProducer
) {
    @Transactional
    fun apply(userId: Long) {
        val count = couponCountRepository.increment()
        if (count > COUPON_MAX_COUNT) {
            return
        }
        couponCreateProducer.create(userId)
    }
}