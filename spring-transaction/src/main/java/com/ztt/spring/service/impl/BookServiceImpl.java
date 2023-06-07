package com.ztt.spring.service.impl;

import com.ztt.spring.dao.BookDao;
import com.ztt.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    @Transactional(
           //readOnly = true
            //timeout = 3
            //noRollbackFor = ArithmeticException.class
            //isolation = Isolation.DEFAULT
            propagation = Propagation.REQUIRES_NEW
    )
    public void buyBook(Integer userId, Integer bookId) {
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Integer price=bookDao.getPriceByBookId(bookId);
        bookDao.updateStock(bookId);
        bookDao.updateBalance(userId,price);
        //System.out.println(1/0);
    }
}
