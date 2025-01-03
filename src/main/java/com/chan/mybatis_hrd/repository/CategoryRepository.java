package com.chan.mybatis_hrd.repository;

import com.chan.mybatis_hrd.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryRepository {

    @Select("""
            SELECT  c.category_id, b.title,b.public_date,c.name FROM books AS b
        INNER  JOIN  book_category AS bc ON b.book_id = bc.book_id
        INNER JOIN categories c on bc.category_id = c.category_id
        WHERE b.book_id=#{id}
        """)
    List<Category>findAllCategoriesById(Integer id);

}
