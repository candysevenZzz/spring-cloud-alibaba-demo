package com.cloud.common._enum;

import lombok.Getter;

/**
 * @author candy_seven
 * @date 2023/2/8 09:59
 */
@Getter
public enum PermissionEnum {
    USER_ALL("user_all", "用户全部权限"),

    SUPER_ADMIN("super_admin","超级管理员"),

    ADMIN_ADD("admin_add","管理员新增权限"),
    ADMIN_UPDATE("admin_update","管理员修改权限"),
    ADMIN_DELETE("admin_delete","管理员删除权限");

    private String code;

    private String msg;

    PermissionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
