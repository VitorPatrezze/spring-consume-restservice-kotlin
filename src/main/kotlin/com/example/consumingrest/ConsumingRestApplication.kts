package com.example.consumingrest

import com.sun.org.slf4j.internal.LoggerFactory
import org.slf4j.Logger
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class ConsumingRestApplication {
    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate {
        return builder.build()
    }

    @Bean
    @Throws(Exception::class)
    fun run(restTemplate: RestTemplate): CommandLineRunner {
        return CommandLineRunner { args ->
            val quote: Quote = restTemplate.getForObject(
                    "https://gturnquist-quoters.cfapps.io/api/random", Quote::class.java)
            com.example.consumingrest.ConsumingRestApplication.Companion.log.info(quote.toString())
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(com.example.consumingrest.ConsumingRestApplication::class.java)
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(com.example.consumingrest.ConsumingRestApplication::class.java, args)
        }
    }
}