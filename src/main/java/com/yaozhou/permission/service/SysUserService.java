package com.yaozhou.permission.service;

import com.yaozhou.permission.model.SysUser;
import com.yaozhou.permission.params.UserParam;
import com.yaozhou.permission.status.StatusCode;

/**
 * @author Yao.Zhou
 * @since 2018/7/22 16:58
 */
public interface SysUserService extends StatusCode {

    /**
     * 添加用户
     * @param userParam
     */
    public void add(UserParam userParam);

    /**
     * 更新用户
     * @param userParam
     */
    public void update(UserParam userParam);

    /**
     * 根据用户名获得用户
     * @param username
     * @return
     */
    public SysUser selectByUserName(String username);

}
