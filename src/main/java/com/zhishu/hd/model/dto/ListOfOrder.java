package com.zhishu.hd.model.dto;

import lombok.Data;

@Data
public class ListOfOrder {
    String orderUser;
    String orderTime;
    float orderPrice;
    BookInOrder[] bookList;
}
