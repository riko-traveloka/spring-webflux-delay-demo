package com.traveloka.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono
import java.time.Duration

@SpringBootApplication
class DelayApplication

fun main(args: Array<String>) {
	runApplication<DelayApplication>(*args)
}

@RestController
class DelayController {
	@GetMapping("/delay")
	fun getUserWithDelay(@RequestParam delay: Long): Mono<String> {
		return Mono.just("OLOLO").delayElement(Duration.ofMillis(delay))
	}
}