package com.zhishu.hd.model.dao.mapper;

import com.zhishu.hd.model.dao.entity.Orderbook;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrderbookMapper extends Mapper<Orderbook> {

    @Insert("insert into orderbook(orderid, isbn, booknum) values ('${id}', '${isbn}', '${num}') ")
    void insertBookOfOrder(int id, String isbn, int num);

    @Select("select * from orderbook where orderid=${id}")
    Orderbook[] getBooksById(int id);
}