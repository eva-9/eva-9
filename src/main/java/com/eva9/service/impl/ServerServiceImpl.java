package com.eva9.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.eva9.common.util.CommandUtil;
import com.eva9.common.util.CommonUtil;
import com.eva9.common.util.constants.ErrorEnum;
import com.eva9.common.util.model.CommandResult;
import com.eva9.mapper.ServerMapper;
import com.eva9.service.LoginService;
import com.eva9.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-11 21:25
 **/
@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerMapper serverMapper;
    @Autowired
    private LoginService loginService;

    @Override
    public JSONObject listServer(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = serverMapper.countServer(jsonObject);
        List<JSONObject> list = serverMapper.listServer(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public JSONObject addServer(JSONObject jsonObject) {
        JSONObject userInfo = loginService.getInfo();
        if (userInfo == null) {
            return CommonUtil.errorJson(ErrorEnum.E_20011);
        }
        jsonObject.put("userName", ((JSONObject)((JSONObject)userInfo.get("info")).get("userPermission")).get("nickname"));
        serverMapper.addServer(jsonObject);
        return CommonUtil.successJson();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public JSONObject updateServer(JSONObject jsonObject) {
        JSONObject userInfo = loginService.getInfo();
        if (userInfo == null) {
            return CommonUtil.errorJson(ErrorEnum.E_20011);
        }
        jsonObject.put("userName", ((JSONObject)((JSONObject)userInfo.get("info")).get("userPermission")).get("nickname"));
        serverMapper.updateServer(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject connectServer(JSONObject jsonObject) {
        StringBuilder command = new StringBuilder();
        command.append("ssh ");
        command.append("root@" + jsonObject.get("ip"));
        CommandResult exec = CommandUtil.exec(command.toString());
        command.append(jsonObject.get("username"));
        command.append(jsonObject.get("password"));
        return CommonUtil.successJson(exec);
    }

}
