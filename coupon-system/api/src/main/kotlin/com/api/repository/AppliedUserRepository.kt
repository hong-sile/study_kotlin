package com.api.repository

import lombok.RequiredArgsConstructor
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class AppliedUserRepository(
    private val redisTemplate: RedisTemplate<String, String>
) {

    fun add(userId: Long): Long? {
        return redisTemplate
            .opsForSet()
            .add("applied_user", userId.toString())
    }
}