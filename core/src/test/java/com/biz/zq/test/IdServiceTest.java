package com.biz.zq.test;

import com.biz.zq.baseservice.IdService;

public class IdServiceTest {

    public static void main(String[] args) {
        IdService idService = new IdService(1, 1);
        System.out.println(idService.nextId());
    }
}
