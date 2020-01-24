package com.eva9.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-11 21:24
 **/
public interface ServerService {

    /**
     * 服务器列表
     * @param jsonObject
     * @return
     */
    JSONObject listServer(JSONObject jsonObject);

    /**
     * 新增服务器
     * @param jsonObject
     * @return
     */
    JSONObject addServer(JSONObject jsonObject);

    /**
     * 修改服务器
     * @param jsonObject
     * @return
     */
    JSONObject updateServer(JSONObject jsonObject);

    /**
     * 连接服务器
     * @param jsonObject
     * @return
     */
    JSONObject connectServer(JSONObject jsonObject);

}
