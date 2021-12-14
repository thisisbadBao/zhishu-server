package com.zhishu.hd.service;

import com.zhishu.hd.model.dto.*;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {

    Object register(Register register);

    Object login(Login login);
}
