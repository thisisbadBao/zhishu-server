package com.zhishu.hd.model.dto;

import javafx.beans.binding.ObjectExpression;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    int code;
    String msg;
    Object data;
}
