package pers.dandandog.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dandandog.framework.core.entity.AuditableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.dandandog.admin.entity.enums.UserGender;
import pers.dandandog.admin.entity.enums.UserState;

import java.time.LocalDateTime;


/**
 * 系统用户表(SysUser)实体类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("auth_user")
public class AuthUser extends AuditableEntity {
    private static final long serialVersionUID = -32722285353331566L;

    /**
     * 昵称
     */
    private String nickname;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 状态（0：正常；1： 冻结；2：未激活)
     */
    private UserState state;
    /**
     * 性别（0：男；1： 女；2：未知)
     */
    private UserGender gender;
    /**
     * 头像
     */
    private String avatarUrl;
    /**
     * 备注
     */
    private String remark;
    /**
     * 密码上次更新时间
     */
    private LocalDateTime pwdRestTime;

    /**
     * 有效时间
     */
    private LocalDateTime expiredTime;

}