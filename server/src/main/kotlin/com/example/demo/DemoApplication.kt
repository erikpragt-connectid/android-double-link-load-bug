package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@RestController
class EchoController(val cache: RefCache) {

    @GetMapping("/echo")
    fun echo(@RequestParam("ref") ref: String, @RequestHeader httpHeaders: Map<String, String>): Map<String, MutableList<Map<String, String>>?> {
        cache.store(ref, httpHeaders.filterKeys { it == "user-agent" })
        return mapOf(ref to cache.get(ref))
    }

    @GetMapping("/dump")
    fun dump(): Map<String, MutableList<Map<String, String>>?> {
        return cache.all()
    }
}

@Component
object RefCache {

    private val content: MutableMap<String, MutableList<Map<String, String>>> = mutableMapOf()

    fun store(ref: String, headers: Map<String, String>) {
        content.getOrPut(ref) { mutableListOf() }.add(headers)
    }

    fun get(ref: String) = content[ref]

    fun all() = content
}
