package com.chan.mybatis_hrd.service.serviceimpl;

import com.chan.mybatis_hrd.model.Book;
import com.chan.mybatis_hrd.repository.BookRepository;
import com.chan.mybatis_hrd.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> findAllBooks(Integer offset,Integer limit) {
        offset=(offset-1)*limit;
        System.out.println(offset);
        System.out.println(limit);
        return bookRepository.findAllBooks(offset,limit);
    }
}
