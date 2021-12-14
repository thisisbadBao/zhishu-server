package com.zhishu.hd.service.impl;

import com.zhishu.hd.model.dao.entity.Book;
import com.zhishu.hd.model.dao.mapper.BookMapper;
import com.zhishu.hd.model.dto.BookInfo;
import com.zhishu.hd.model.dto.Result;
import com.zhishu.hd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public String getRepeatableNumberCode(int len) {
        // 生成n位可重复数字串
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; ++i) {
            stringBuilder.append(random.nextInt(65535) % 10);
        }
        return stringBuilder.toString();
    }

    @Override
    public Object addBook(BookInfo bookInfo){
        Book book = new Book();
        book.setBookname(bookInfo.getBookName());
        book.setBookauthor(bookInfo.getBookAuthor());
        if( bookMapper.selectByNameAndAuthor(book.getBookname(), book.getBookauthor()) != null ){
            return new Result(4,"该书本已存在",null);
        }else {
            String isbn = getRepeatableNumberCode(1)+"-"+getRepeatableNumberCode(3)
                    +"-"+getRepeatableNumberCode(5)+"-"+getRepeatableNumberCode(1);
            book.setIsbn(isbn);
            book.setBooknote(bookInfo.getBookNote());
            book.setBookpic(bookInfo.getBookPic());
            book.setBookprice(bookInfo.getBookPrice());
            book.setBookremain(bookInfo.getBookRemain());
            book.setBookstate(!bookInfo.isBookState());//前端输入true表示正在销售，用0代表
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try{
                Date date = simpleDateFormat.parse(bookInfo.getBookRelease());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR, 8);
                date = calendar.getTime();
                book.setBookrelease(date);
            }catch (ParseException e){
                e.printStackTrace();
            }
            bookMapper.insert(book);
            return new Result(200,"添加书本成功",null);
        }
    }

    @Override
    public Object searchBook(String bookName) {
        Book[] bookArray = bookMapper.selectByName(bookName);
        if(bookArray.length == 0) {
            return new Result(5,"没有该名称的书本",null);
        }

        for (Book book : bookArray) {
            Date date = book.getBookrelease();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.HOUR, 8);
            date = calendar.getTime();
            book.setBookrelease(date);
        }
        return new Result(200,"查询成功",bookArray);
    }

    @Override
    public Object allBook() {
        Book[] books = bookMapper.allBook();

        for (Book book : books) {
            Date date = book.getBookrelease();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.HOUR, 8);
            date = calendar.getTime();
            book.setBookrelease(date);
        }
        return new Result(200,"查询成功",books);
    }
}
