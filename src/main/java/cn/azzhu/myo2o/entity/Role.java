package cn.azzhu.myo2o.entity;

import lombok.Data;

@Data
public class Role {
    private Integer roleid;

    private String rolename;

    private String roledesc;

    private Integer available;

}