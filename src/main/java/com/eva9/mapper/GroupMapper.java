package com.eva9.mapper;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-24 09:14
 **/
@Repository
public interface GroupMapper {

    /**
     * 组列表
     * @param jsonObject
     * @return
     */
    List<JSONObject> listGroup(JSONObject jsonObject);

    /**
     * 统计组总数
     * @param jsonObject
     * @return
     */
    int countGroup(JSONObject jsonObject);

    /**
     * 新增组
     * @param jsonObject
     * @return
     */
    int addGroup(JSONObject jsonObject);

    /**
     * 修改组
     * @param jsonObject
     * @return
     */
    int updateGroup(JSONObject jsonObject);

    /**
     * 删除组
     * @param jsonObject
     * @return
     */
    int delGroup(JSONObject jsonObject);

}
