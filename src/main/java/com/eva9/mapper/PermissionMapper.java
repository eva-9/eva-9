package com.eva9.mapper;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author: Steve Jin
 * @date: 2019-12-26 13:28
 */
@Repository
public interface PermissionMapper {
	/**
	 * 查询用户的角色 菜单 权限
	 */
	JSONObject getUserPermission(String username);

	/**
	 * 查询所有的菜单
	 */
	Set<String> getAllMenu();

	/**
	 * 查询所有的权限
	 */
	Set<String> getAllPermission();
}
