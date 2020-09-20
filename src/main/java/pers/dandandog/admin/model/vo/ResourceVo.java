package pers.dandandog.admin.model.vo;

import lombok.Data;
import pers.dandandog.admin.entity.enums.ResourceType;

@Data
public class ResourceVo {

    private String id;

    private String title;

    private String code;

    private String parentId;

    private String path;

    private String perms;

    private ResourceType type;

    private String icon;

    private Integer seq;

    private Boolean display;

    private Boolean frame;

    private Integer level;

}
