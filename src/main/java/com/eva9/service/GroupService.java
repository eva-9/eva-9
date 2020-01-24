package com.eva9.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-24 09:22
 **/
public interface GroupService {

    /**
     * 组列表
     * @param jsonObject
     * @return
     */
    JSONObject listGroup(JSONObject jsonObject);

    /**
     * 新增组
     * @param jsonObject
     * @return
     */
    JSONObject addGroup(JSONObject jsonObject);

    /**
     * 修改组
     * @param jsonObject
     * @return
     */
    JSONObject updateGroup(JSONObject jsonObject);

    /**
     * 删除组
     * @param jsonObject
     * @return
     */
    JSONObject delGroup(JSONObject jsonObject);

}
