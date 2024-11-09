package com.api.repository

import lombok.RequiredArgsConstructor
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class CouponCountRepository(
    private val redisTemplate: RedisTemplate<String, String>
) {
    fun increment(): Long {
        return redisTemplate
            .opsForValue()
            .increment("coupon_count") ?: 0L
    }
}