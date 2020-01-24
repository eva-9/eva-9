package com.eva9.controller;

import com.alibaba.fastjson.JSONObject;
import com.eva9.common.util.CommonUtil;
import com.eva9.service.GroupService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-24 09:27
 **/
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    /**
     * 查询服务器列表
     * @param request
     * @return
     */
    @RequiresPermissions("group:list")
    @GetMapping("/listGroup")
    public JSONObject listGroup(HttpServletRequest request) {
        return groupService.listGroup(CommonUtil.request2Json(request));
    }

    /**
     * 新增服务器
     * @param requestJson
     * @return
     */
    @RequiresPermissions("group:add")
    @PostMapping("/addGroup")
    public JSONObject addGroup(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "uid,name");
        return groupService.addGroup(requestJson);
    }

    /**
     * 修改服务器
     * @param requestJson
     * @return
     */
    @RequiresPermissions("group:update")
    @PostMapping("/updateGroup")
    public JSONObject updateGroup(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id,uid,name");
        return groupService.updateGroup(requestJson);
    }

    /**
     * 删除组
     * @param requestJson
     * @return
     */
    @RequiresPermissions("group:delete")
    @PostMapping("/delGroup")
    public JSONObject delGroup(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        return groupService.delGroup(requestJson);
    }

}
