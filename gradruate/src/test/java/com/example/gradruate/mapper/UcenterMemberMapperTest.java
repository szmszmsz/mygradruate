package com.example.gradruate.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UcenterMemberMapperTest {
    @Resource
    UcenterMemberMapper ucenterMemberMapper;
    @Test
    void queryParams() {
        ucenterMemberMapper.queryParams("小");
    }

    @Test
    void testQueryParams() {
    }
}