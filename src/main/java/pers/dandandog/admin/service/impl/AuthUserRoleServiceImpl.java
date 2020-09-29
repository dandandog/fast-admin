package pers.dandandog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.dandandog.admin.dao.AuthUserRoleDao;
import pers.dandandog.admin.entity.AuthUserRole;
import pers.dandandog.admin.service.AuthUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 系统用户角色关系表(SysUserRole)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service("sysUserRoleService")
public class AuthUserRoleServiceImpl extends ServiceImpl<AuthUserRoleDao, AuthUserRole> implements AuthUserRoleService {

}