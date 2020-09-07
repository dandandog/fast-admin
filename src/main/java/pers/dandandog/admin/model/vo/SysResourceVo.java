package pers.dandandog.admin.model.vo;

import lombok.Data;

@Data
public class SysResourceVo {

    private String id;

    private String title;

    private String code;

    private String parentId;

    private String path;

    private String perms;

    private Integer type;

    private String icon;

    private Integer seq;

    private Boolean display;

    private Boolean frame;

    private Integer level;

}
