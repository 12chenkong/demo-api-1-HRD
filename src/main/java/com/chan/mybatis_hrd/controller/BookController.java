package com.chan.mybatis_hrd.controller;

import com.chan.mybatis_hrd.model.APIRespone;
import com.chan.mybatis_hrd.model.Book;
import com.chan.mybatis_hrd.service.BookService;
import com.chan.mybatis_hrd.service.serviceimpl.BookServiceImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> findAllBooks(){
        return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.OK
        );

    }

}
