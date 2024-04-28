package com.tcc.spg.user.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController {

    @GetMapping("/test")
    fun register(): String {
        return "Aplication Running"
    }
}