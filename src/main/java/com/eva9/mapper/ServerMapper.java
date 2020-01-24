package com.eva9.mapper;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-11 20:58
 **/
@Repository
public interface ServerMapper {

    /**
     * 服务器列表
     * @param jsonObject
     * @return
     */
    List<JSONObject> listServer(JSONObject jsonObject);

    /**
     * 统计服务器总数
     * @param jsonObject
     * @return
     */
    int countServer(JSONObject jsonObject);

    /**
     * 新增服务器
     * @param jsonObject
     * @return
     */
    int addServer(JSONObject jsonObject);

    /**
     * 修改服务器
     * @param jsonObject
     * @return
     */
    int updateServer(JSONObject jsonObject);

}
