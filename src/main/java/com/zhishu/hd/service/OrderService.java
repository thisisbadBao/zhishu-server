package com.zhishu.hd.service;

import com.zhishu.hd.model.dto.ListOfOrder;
import org.springframework.validation.annotation.Validated;

@Validated
public interface OrderService {

    Object insertOrder(ListOfOrder orderList);

    Object getAllOrder();
}
