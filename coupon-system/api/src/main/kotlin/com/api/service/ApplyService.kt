package com.api.service

import com.api.domain.Coupon
import com.api.repository.CouponRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private const val COUPON_MAX_COUNT = 100

@Service
@RequiredArgsConstructor
class ApplyService(
    val couponRepository: CouponRepository
) {

    @Transactional
    fun apply(userId: Long) {
        val count = couponRepository.count()
        if(count > COUPON_MAX_COUNT) {
            return
        }
        couponRepository.save(Coupon(userId = userId))
    }
}