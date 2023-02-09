package com.cloud.gateway.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.cloud.common._enum.LoginTypeEnum;
import com.cloud.common._enum.PermissionEnum;
import com.cloud.common._enum.RoleEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author candy_seven
 * @date 2023/2/7 21:54
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    private static final List<String> permissionList = new ArrayList<>();

    private static final List<String> roleList = new ArrayList<>();

    private static final List<String> adminPermissionList = new ArrayList<>();

    private static final List<String> adminRoleList = new ArrayList<>();

    static {
        //权限列表
        permissionList.add(PermissionEnum.USER_ALL.getCode());
        //角色列表
        roleList.add(RoleEnum.VISITOR.getCode());
        roleList.add(RoleEnum.CUSTOMER.getCode());
        roleList.add(RoleEnum.MEMBER.getCode());

        //权限列表
        adminPermissionList.add(PermissionEnum.SUPER_ADMIN.getCode());
        adminPermissionList.add(PermissionEnum.ADMIN_ADD.getCode());
        adminPermissionList.add(PermissionEnum.ADMIN_UPDATE.getCode());
        adminPermissionList.add(PermissionEnum.ADMIN_DELETE.getCode());
        //角色列表
        adminRoleList.add(RoleEnum.ADMIN.getCode());
        adminRoleList.add(RoleEnum.SUPER_ADMIN.getCode());
    }

    /**
     * 返回指定账号id所拥有的权限码集合
     *
     * @param loginId   账号id
     * @param loginType 账号类型
     * @return 该账号id具有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        if (loginType.equals(LoginTypeEnum.ADMIN_LOGIN.getCode())) {
            return adminPermissionList;
        }

        return permissionList;
    }

    /**
     * 返回指定账号id所拥有的角色标识集合
     *
     * @param loginId   账号id
     * @param loginType 账号类型
     * @return 该账号id具有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        if (loginType.equals(LoginTypeEnum.ADMIN_LOGIN.getCode())) {
            return adminRoleList;
        }

        return roleList;
    }
}
