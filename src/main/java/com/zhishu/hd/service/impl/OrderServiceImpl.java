package com.zhishu.hd.service.impl;

import com.zhishu.hd.model.dao.entity.Book;
import com.zhishu.hd.model.dao.entity.Orderbook;
import com.zhishu.hd.model.dao.entity.Orderlist;
import com.zhishu.hd.model.dao.mapper.BookMapper;
import com.zhishu.hd.model.dao.mapper.OrderbookMapper;
import com.zhishu.hd.model.dao.mapper.OrderlistMapper;
import com.zhishu.hd.model.dto.BookInOrder;
import com.zhishu.hd.model.dto.ListOfOrder;
import com.zhishu.hd.model.dto.OList;
import com.zhishu.hd.model.dto.Result;
import com.zhishu.hd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderlistMapper orderlistMapper;

    @Autowired
    private OrderbookMapper orderbookMapper;

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
    public Object insertOrder(ListOfOrder orderList) {
        int orderId = Integer.parseInt(getRepeatableNumberCode(5));
        while( orderlistMapper.selectById(orderId) != null ){
            orderId = Integer.parseInt(getRepeatableNumberCode(5));
        }
        Orderlist order = new Orderlist();
        order.setOrderid(orderId);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = simpleDateFormat.parse(orderList.getOrderTime());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.HOUR, 8);
            date = calendar.getTime();
            order.setOrdertime(date);
        }catch (ParseException e){
            e.printStackTrace();
        }

        order.setOrderprice(orderList.getOrderPrice());
        order.setOrderuser(orderList.getOrderUser());
        order.setOrderstate(0);

        orderlistMapper.insert(order);

        for(BookInOrder bookInOrder : orderList.getBookList()){
            String isbn = bookMapper.selectByNameAndAuthor(bookInOrder.getBookName(),
                    bookInOrder.getBookAuthor()).getIsbn();
            orderbookMapper.insertBookOfOrder(orderId, isbn, bookInOrder.getBookNum());
        }

        return new Result(200,"增加订单成功",null);
    }

    @Override
    public Object getAllOrder() {
        Orderlist[] orderlists = orderlistMapper.selectAllOrder();
//        System.out.println(orderlists.length);
        OList[] lists = new OList[orderlists.length];
        for(int i=0;i<orderlists.length;i++){
            lists[i] = new OList();
            lists[i].setOrderUser(orderlists[i].getOrderuser());
            lists[i].setOrderTime(orderlists[i].getOrdertime().toString());
            lists[i].setOrderPrice(orderlists[i].getOrderprice());
            lists[i].setOrderState(orderlists[i].getOrderstate());
            Orderbook[] books = orderbookMapper.getBooksById(orderlists[i].getOrderid());
            BookInOrder[] temp = new BookInOrder[books.length];
            for(int j=0;j<books.length;j++){
                Book bookTmp = bookMapper.selectByID(books[j].getIsbn());
                temp[j] = new BookInOrder();
                temp[j].setBookAuthor(bookTmp.getBookauthor());
                temp[j].setBookName(bookTmp.getBookname());
                temp[j].setBookPrice(bookTmp.getBookprice());
                temp[j].setBookNum(books[j].getBooknum());
            }
            lists[i].setBookList(temp);
        }
        return new Result(200,"查询全部订单成功",lists);
    }
}
