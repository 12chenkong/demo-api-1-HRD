package com.chan.mybatis_hrd.repository;

import com.chan.mybatis_hrd.model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface BookRepository {

    @Select("SELECT * FROM books LIMIT #{limit}  OFFSET #{offset} ")
    @Result(
            property = "author",
            column = "author_id",
            one = @One(select ="com.chan.mybatis_hrd.repository.AuthorRepository.findAuthorById")
    )
    @Result(
            property = "categories",
            column ="book_id",
            many = @Many(select = "com.chan.mybatis_hrd.repository.CategoryRepository.findAllCategoriesById"))
    List<Book>findAllBooks(@Param("offset") Integer offset,@Param("limit") Integer limit);


}
