package com.zhishu.hd.model.dto;

import lombok.Data;

@Data
public class BookInfo {
    String bookName;
    String bookAuthor;
    float bookPrice;
    Integer bookRemain;
    String bookRelease;
    boolean bookState;
    String bookNote;
    String bookPic;

}
