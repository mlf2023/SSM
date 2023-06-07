package com.ztt.spring.dao;

public interface BookDao {
    void updateStock(Integer bookId);

    void updateBalance(Integer userId, Integer price);

    Integer getPriceByBookId(Integer bookId);
}
