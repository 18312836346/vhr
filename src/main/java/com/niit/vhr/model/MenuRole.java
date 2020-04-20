package com.niit.vhr.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuRole implements Serializable {
    private Integer id;

    private Integer mid;

    private Integer rid;

    private static final long serialVersionUID = 1L;
}