package com.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ConsumerApplication

fun main(args: Array<String>) {
	runApplication<ConsumerApplication>(*args)
}
