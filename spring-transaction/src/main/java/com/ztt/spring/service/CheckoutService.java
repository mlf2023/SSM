package com.ztt.spring.service;

public interface CheckoutService {
    void checkout(Integer userId, Integer[] bookIds);
}
