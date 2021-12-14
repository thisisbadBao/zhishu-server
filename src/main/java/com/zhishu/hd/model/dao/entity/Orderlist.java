package com.zhishu.hd.model.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderlist {
    private Integer orderid;

    private String orderuser;

    private Date ordertime;

    private Integer orderstate;

    private Float orderprice;
}