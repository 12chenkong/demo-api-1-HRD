package com.chan.mybatis_hrd.service;

import com.chan.mybatis_hrd.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    List<Book>findAllBooks(Integer offset,Integer limit);
}
