package pers.dandandog.projects.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dandandog.framework.common.model.ITree;
import com.dandandog.framework.core.entity.AuditableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.dandandog.projects.admin.entity.enums.ResourceTarget;
import pers.dandandog.projects.admin.entity.enums.ResourceType;


/**
 * 系统资源表(SysResource)实体类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("auth_resource")
public class AuthResource extends AuditableEntity implements ITree {
    private static final long serialVersionUID = 916304099916723584L;

    /**
     * 菜单标题
     */
    private String title;
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
    private ResourceType type = ResourceType.CATALOG;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer seq = 0;
    /**
     * 是否显示
     */
    private Boolean display;
    /**
     * 打开方式
     */
    private ResourceTarget target = ResourceTarget.CURR_PAGE;
    /**
     * 层级
     */
    private Integer level = 0;


}