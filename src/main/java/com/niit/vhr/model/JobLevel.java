package com.niit.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class JobLevel {
    private Integer id;
//职称名称
    private String name;
//职称等级
    private String titleLevel;
//创建职称的时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:hh", timezone = "Asia/Shanghai")
    private Date createDate;
//是否启用
    private Boolean enabled;


}