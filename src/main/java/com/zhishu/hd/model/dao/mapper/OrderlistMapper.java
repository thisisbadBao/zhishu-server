package com.zhishu.hd.model.dao.mapper;


import com.zhishu.hd.model.dao.entity.Orderlist;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrderlistMapper extends Mapper<Orderlist> {
    @Select("select * from orderlist where orderid=${id} ")
    Orderlist selectById(int id);

    @Select("select * from orderlist")
    Orderlist[] selectAllOrder();
}