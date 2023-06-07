package com.ztt.spring.test;

import com.ztt.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXML {
    @Autowired
    private BookController bookController;
    @Test
    public void testBuyBook(){

        bookController.buyBook(1,1);
    }
}
