package com.chan.mybatis_hrd.repository;

import com.chan.mybatis_hrd.model.Author;
import com.chan.mybatis_hrd.model.dto.AuthorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface AuthorRepository {

    @Select("SELECT * FROM authors ")
    List<Author> findAllAuthor();

    @Select("SELECT * FROM authors WHERE author_id=#{id} ")
    Author findAuthorById(Integer id);

    @Delete("DELETE FROM authors WHERE author_id=#{id} ")
    boolean deleteAuthorById( Integer id);
    @Update("UPDATE authors SET " +
            " name=#{author.name}, gender=#{author.gender} " +
            "WHERE author_id=#{id}" )
    int updateAuthor(@Param("author") AuthorRequest authorRequest,Integer id);

    @Insert("INSERT INTO authors (name,gender) VALUES (#{author.name},#{author.gender}) ")
    int createAuthor(@Param("author") AuthorRequest authorRequest);





}