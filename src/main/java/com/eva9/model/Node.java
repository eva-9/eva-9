package com.eva9.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-11 19:36
 **/
@Data
public class Node {

    private Integer id;
    private Integer serverId;
    private String name;
    private Integer port;
    private String remark;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;

}
