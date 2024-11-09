package com.api.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import lombok.Getter
import lombok.ToString

@Entity
@Getter
@ToString
class Coupon(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    val userId: Long
)