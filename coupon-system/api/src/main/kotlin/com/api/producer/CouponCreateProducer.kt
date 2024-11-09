package com.api.producer

import lombok.RequiredArgsConstructor
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
@RequiredArgsConstructor
class CouponCreateProducer(
    private val kafkaTemplate: KafkaTemplate<String, Long>
) {

    fun create(userId: Long) {
        println("coupon_create")
        println(userId)
        kafkaTemplate.send("coupon_create", userId)
    }
}