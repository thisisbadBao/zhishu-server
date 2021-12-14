package com.zhishu.hd.service;

import com.zhishu.hd.model.dto.BookInfo;
import org.springframework.validation.annotation.Validated;

@Validated
public interface BookService {

    Object addBook(BookInfo bookInfo);

    Object searchBook(String bookName);

    Object allBook();
}
