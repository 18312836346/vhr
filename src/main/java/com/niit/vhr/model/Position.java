package com.niit.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Position {
    private Integer id;
//职位名称
    private String name;
//创新职位的时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:hh", timezone = "Asia/Shanghai")
    private Date createDate;
//是否启用
    private Boolean enabled;
}