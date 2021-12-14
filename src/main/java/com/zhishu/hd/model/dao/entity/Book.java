package com.zhishu.hd.model.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private String isbn;

    private String bookname;

    private String bookauthor;

    private Float bookprice;

    private Integer bookremain;

    private Date bookrelease;

    private Boolean bookstate;

    private String bookpic;

    private String booknote;
}