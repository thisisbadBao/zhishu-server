package com.zhishu.hd.controller;

import com.zhishu.hd.model.dto.ListOfOrder;
import com.zhishu.hd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public Object insertOrder(@RequestBody ListOfOrder orderList){
        return orderService.insertOrder(orderList);
    }

    @GetMapping("/allOrder")
    public Object getAllOrder(){
        return orderService.getAllOrder();
    }
}
