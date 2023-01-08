package com.example.gradruate.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UcenterMemberServiceTest {

    @Autowired
    UcenterMemberService ucenterMemberService;
    @Test
    void queryParams() {
        ucenterMemberService.queryParams("小");
    }
}