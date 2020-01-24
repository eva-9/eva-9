package com.eva9.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: Steve Jin
 * @date: 2019-12-26 13:10
 */
public interface PermissionService {
	/**
	 * 查询某用户的 角色  菜单列表   权限列表
	 */
	JSONObject getUserPermission(String username);
}
