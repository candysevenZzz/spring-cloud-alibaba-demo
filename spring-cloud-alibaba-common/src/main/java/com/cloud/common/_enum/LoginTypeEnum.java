package com.cloud.common._enum;

import lombok.Getter;

/**
 * @author candy_seven
 * @date 2023/2/8 10:16
 */
@Getter
public enum LoginTypeEnum {

    ADMIN_LOGIN("admin_login","管理员登录类型"),
    CUSTOMER_LOGIN("customer_login","用户登录类型");

    private String code;

    private String msg;

    LoginTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
