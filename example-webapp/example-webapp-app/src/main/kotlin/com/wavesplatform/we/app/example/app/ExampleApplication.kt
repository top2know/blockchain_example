package com.wavesplatform.we.app.example.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ExampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(ExampleApplication::class.java, *args)
}
