package com.cloud.common._enum;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author candy_seven
 * @date 2023/2/8 09:51
 */
@Getter
public enum RoleEnum {
    ADMIN("admin", "普通管理员"),
    SUPER_ADMIN("super_admin", "超级管理员"),


    VISITOR("visitor", "游客"),
    CUSTOMER("customer","注册用户"),
    MEMBER("member","付费会员");

    private String code;

    private String msg;

    RoleEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static List<String> getList() {
        List<String> list = new ArrayList<>();

        for (RoleEnum item : RoleEnum.values()) {
            list.add(item.getCode());
        }

        return list;
    }
}
