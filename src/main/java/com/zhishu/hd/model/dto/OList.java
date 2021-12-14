package com.zhishu.hd.model.dto;

import lombok.Data;

@Data
public class OList {
    String orderUser;
    String orderTime;
    float orderPrice;
    int orderState;
    BookInOrder[] bookList;
}
