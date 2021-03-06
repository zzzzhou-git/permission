package com.yaozhou.permission.controllers;

import com.yaozhou.permission.service.*;
import com.yaozhou.permission.status.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author Yao.Zhou
 * @since 2018/7/17 23:45
 */
public abstract class BaseController implements StatusCode {

    @Autowired
    protected ApplicationContext applicationContext;

    @Autowired
    protected AuthService authService;
    @Autowired
    protected SysAclService sysAclService;
    @Autowired
    protected SysCoreService sysCoreService;
    @Autowired
    protected SysRoleService sysRoleService;
    @Autowired
    protected SysTreeService sysTreeService;
    @Autowired
    protected SysDeptService sysDeptService;
    @Autowired
    protected SysUserService sysUserService;
    @Autowired
    protected SysRoleAclService sysRoleAclService;
    @Autowired
    protected SysRoleUserService sysRoleUserService;
    @Autowired
    protected SysAclModuleService sysAclModuleService;


    public <T> T popBean(Class<T> clazz) {
        if (null == applicationContext) {

            return null;
        }

        return applicationContext.getBean(clazz);
    }

    public <T> T popBean(String name, Class<T> clazz) {
        if (null == applicationContext) {

            return null;
        }

        return applicationContext.getBean(name, clazz);
    }

}
