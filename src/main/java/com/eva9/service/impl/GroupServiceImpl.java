package com.eva9.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.eva9.common.util.CommonUtil;
import com.eva9.common.util.constants.ErrorEnum;
import com.eva9.mapper.GroupMapper;
import com.eva9.mapper.UserMapper;
import com.eva9.service.GroupService;
import com.eva9.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-24 09:23
 **/
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject listGroup(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        jsonObject.put("name", "%" + jsonObject.get("name") + "%");
        int count = groupMapper.countGroup(jsonObject);
        List<JSONObject> list = groupMapper.listGroup(jsonObject);
        list.stream().forEach(x -> {
            JSONObject param = new JSONObject();
            param.put("id", x.get("uid"));
            x.put("nickname", userMapper.getUserById(param).get("nickname"));
        });
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject addGroup(JSONObject jsonObject) {
        JSONObject userInfo = loginService.getInfo();
        if (userInfo == null) {
            return CommonUtil.errorJson(ErrorEnum.E_20011);
        }
        jsonObject.put("userName", ((JSONObject)((JSONObject)userInfo.get("info")).get("userPermission")).get("nickname"));
        groupMapper.addGroup(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject updateGroup(JSONObject jsonObject) {
        JSONObject userInfo = loginService.getInfo();
        if (userInfo == null) {
            return CommonUtil.errorJson(ErrorEnum.E_20011);
        }
        jsonObject.put("userName", ((JSONObject)((JSONObject)userInfo.get("info")).get("userPermission")).get("nickname"));
        groupMapper.updateGroup(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject delGroup(JSONObject jsonObject) {
        JSONObject userInfo = loginService.getInfo();
        if (userInfo == null) {
            return CommonUtil.errorJson(ErrorEnum.E_20011);
        }
        jsonObject.put("userName", ((JSONObject)((JSONObject)userInfo.get("info")).get("userPermission")).get("nickname"));
        groupMapper.delGroup(jsonObject);
        return CommonUtil.successJson();
    }

}
