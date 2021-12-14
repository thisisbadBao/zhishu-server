package com.zhishu.hd.model.dto;

import lombok.Data;

@Data
public class BookInOrder {
    String bookName;
    String bookAuthor;
    Integer bookNum;
    float bookPrice;
}
