package com.chan.mybatis_hrd.service.serviceimpl;

import com.chan.mybatis_hrd.model.Author;
import com.chan.mybatis_hrd.model.dto.AuthorRequest;
import com.chan.mybatis_hrd.repository.AuthorRepository;
import com.chan.mybatis_hrd.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAllAuthors() {

        return authorRepository.findAllAuthor();
    }

    @Override
    public Author findAuthorById(Integer id) {
      return   authorRepository.findAuthorById(id);
    }

    @Override
    public boolean delteAuthorById(Integer id) {
       return authorRepository.deleteAuthorById(id);
    }

    @Override
    public int updateAuthor(AuthorRequest author, Integer id) {
        return  authorRepository.updateAuthor(author,id);
    }

    @Override
    public int createAuthor(AuthorRequest authorRequest) {
        return authorRepository.createAuthor(authorRequest);
    }

    @Override
    public List<Author> getAuthorsByGender(String gender) {
        return authorRepository.findAuthorsByGender(gender);
    }
}
