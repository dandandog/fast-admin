package pers.dandandog.admin.entity;

import com.dandandog.framework.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 系统角色资源关系表(SysRoleResource)实体类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleResource extends BaseEntity {
    private static final long serialVersionUID = -87971289520291131L;

    /**
    * 角色uuid
    */
    private String roleId;
    /**
    * 菜单uuid
    */
    private String resId;

        
}