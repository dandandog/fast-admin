package pers.dandandog.admin.service.impl;

import com.dandandog.framework.core.cache.BaseServiceImpl;
import org.springframework.stereotype.Service;
import pers.dandandog.admin.dao.AuthUserRoleDao;
import pers.dandandog.admin.entity.AuthUserRole;
import pers.dandandog.admin.service.AuthUserRoleService;

/**
 * 系统用户角色关系表(SysUserRole)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service("sysUserRoleService")
public class AuthUserRoleServiceImpl extends BaseServiceImpl<AuthUserRoleDao, AuthUserRole> implements AuthUserRoleService {

}