package com.cloud.gateway.config;

/**
 * @author candy_seven
 * @date 2023/2/7 21:48
 */

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.SaTokenContext;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.cloud.common._enum.PermissionEnum;
import com.cloud.common._enum.RoleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Sa-Token 权限认证] 配置类
 * @author kong
 */
@Configuration
@Slf4j
public class SaTokenConfigure {
    // 注册 Sa-Token全局过滤器
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")    /* 拦截全部path */
                // 开放地址
                .addExclude("/favicon.ico")
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    log.info("请求进来了! url:{}", SaHolder.getRequest().getRequestPath());

                    // 登录校验 -- 拦截所有路由，并排除/login/doLogin 用于开放登录
                    SaRouter.match("/**", "/auth/login/doLogin", r ->  StpUtil.checkLogin());

                    // 权限认证 -- 不同模块, 校验不同权限
                    SaRouter.match("/user/**", r -> StpUtil.checkPermission(PermissionEnum.USER_ALL.getCode()));
                    SaRouter.match("/order/**", r -> StpUtil.checkPermission(PermissionEnum.USER_ALL.getCode()));

                    // 管理端角色权限校验
                    SaRouter.match("/backend/**", r -> StpUtil.checkRoleOr(RoleEnum.ADMIN.getCode(), RoleEnum.SUPER_ADMIN.getCode()));
                })
                // 异常处理方法：每次setAuth函数出现异常时进入
                .setError(e -> SaResult.error(e.getMessage()))
                ;
    }
}

