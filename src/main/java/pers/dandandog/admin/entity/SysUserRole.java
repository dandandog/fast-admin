package pers.dandandog.admin.entity;

import com.dandandog.framework.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 系统用户角色关系表(SysUserRole)实体类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserRole extends BaseEntity {
    private static final long serialVersionUID = -47129877502580903L;

    /**
    * 用户uuid
    */
    private String userId;
    /**
    * 角色uuid
    */
    private String roleId;

        
}