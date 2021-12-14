package com.zhishu.hd.controller;

import com.zhishu.hd.model.dto.*;
import com.zhishu.hd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/search/{bookName}")
    public Object searchBook(@PathVariable(value="bookName") String bookName){
        return bookService.searchBook(bookName);
    }

    @PostMapping("/addBook")
    public Object addBook(@RequestBody BookInfo bookInfo){
        return bookService.addBook(bookInfo);
    }

    @GetMapping("/allBook")
    public Object allBook(){
        return bookService.allBook();
    }
}
