package com.eva9.controller;

import com.alibaba.fastjson.JSONObject;
import com.eva9.common.util.CommonUtil;
import com.eva9.service.ServerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-11 22:01
 **/
@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private ServerService serverService;

    /**
     * 查询服务器列表
     * @param request
     * @return
     */
    @RequiresPermissions("server:list")
    @GetMapping("/listServer")
    public JSONObject listServer(HttpServletRequest request) {
        return serverService.listServer(CommonUtil.request2Json(request));
    }

    /**
     * 新增服务器
     * @param requestJson
     * @return
     */
    @RequiresPermissions("server:add")
    @PostMapping("/addServer")
    public JSONObject addServer(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "name,ip,username,password");
        return serverService.addServer(requestJson);
    }

    /**
     * 修改服务器
     * @param requestJson
     * @return
     */
    @RequiresPermissions("server:update")
    @PostMapping("/updateServer")
    public JSONObject updateServer(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id,name,ip,username,password");
        return serverService.updateServer(requestJson);
    }

    @RequiresPermissions("server:connect")
    @PostMapping("/connectServer")
    public JSONObject connectServer(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "ip,username,password");
        return serverService.connectServer(requestJson);
    }

}
