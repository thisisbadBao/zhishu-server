package com.zhishu.hd.model.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderbook {
    private Integer orderid;

    private String isbn;

    private Integer booknum;
}