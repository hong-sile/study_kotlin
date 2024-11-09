package com.consumer.consumer

import com.consumer.domain.Coupon
import com.consumer.repository.CouponRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class CouponCreateConsumer(
    @Autowired private val couponRepository: CouponRepository
) {

    @KafkaListener(topics = ["coupon_create"], groupId = "group_1")
    fun listener(userId: Long) {
        val coupon = Coupon(userId = userId)
        couponRepository.save(coupon)
    }
}