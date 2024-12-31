package com.chan.mybatis_hrd.service;

import com.chan.mybatis_hrd.model.Author;
import com.chan.mybatis_hrd.model.AuthorRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthorService {

    List<Author> findAllAuthors();
    Author findAuthorById(Integer id);
    boolean delteAuthorById(Integer id);
    int updateAuthor(AuthorRequest author,Integer id);
    int createAuthor(AuthorRequest authorRequest);

}
