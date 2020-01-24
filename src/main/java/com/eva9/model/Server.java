package com.eva9.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-11 19:31
 **/
@Data
public class Server {

    private Integer id;
    private String ip;
    private String name;
    private String username;
    private String password;
    private String remark;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String createBy;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String updateBy;
    private String deleteStatus;

}
