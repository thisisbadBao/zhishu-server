package com.zhishu.hd.model.dao.mapper;

import com.zhishu.hd.model.dao.entity.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface BookMapper extends Mapper<Book> {

    @Select("select * from book where bookname='${bookName}' and bookauthor='${bookAuthor}' ")
    Book selectByNameAndAuthor(String bookName, String bookAuthor);

    @Select("select * from book where bookname='${bookName}' ")
    Book[] selectByName(String bookName);

    @Select("select * from book where isbn='${id}' ")
    Book selectByID(String id);

    @Select("select * from book")
    Book[] allBook();
}