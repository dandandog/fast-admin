package pers.dandandog.admin.entity;

import com.dandandog.framework.core.entity.AuditableEntity;
import com.dandandog.framework.core.entity.ITree;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.dandandog.admin.entity.enums.ResourceType;


/**
 * 系统资源表(SysResource)实体类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysResource extends AuditableEntity implements ITree {
    private static final long serialVersionUID = 916304099916723584L;

    /**
     * 菜单标题
     */
    private String title;
    /**
     * 唯一标识
     */
    private String code;
    /**
     * 父级uuid
     */
    private String parentId;
    /**
     * 路由地址
     */
    private String path;
    /**
     * 权限标识（逗号分隔）
     */
    private String perms;
    /**
     * 类型（0：目录; 1：菜单; 2：按钮）
     */
    private ResourceType type;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer seq;
    /**
     * 是否显示
     */
    private Boolean display;
    /**
     * 是否外部连接
     */
    private Boolean frame;
    /**
     * 层级
     */
    private Integer level;


}