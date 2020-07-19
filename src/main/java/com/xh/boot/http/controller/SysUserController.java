package com.xh.boot.http.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @GetMapping(value = "/test")
    public String test() {
        return "Hello Spring Security";
    }

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping(value = "/testNeed")
    public String testNeed() {
        return "testNeed";
    }
}

