package com.eva9.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-24 09:12
 **/
@Data
public class Group {

    private Integer id;
    private Integer uid;
    private String name;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String createBy;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String updateBy;
    private String deleteStatus;

}
