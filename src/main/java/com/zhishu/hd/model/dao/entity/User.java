package com.zhishu.hd.model.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;

    private String userpassword;

    private String useraddr;

    private String usertel;

    private Boolean userjuris;
}