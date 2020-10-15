package pers.dandandog.admin.service.impl;

import com.dandandog.framework.core.service.BaseServiceImpl;
import com.dandandog.framework.core.service.CacheServiceImpl;
import org.springframework.stereotype.Service;
import pers.dandandog.admin.dao.AuthUserRoleDao;
import pers.dandandog.admin.entity.AuthUserRole;
import pers.dandandog.admin.service.AuthUserRoleService;

/**
 * 系统用户角色关系表(AuthUserRole)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service
public class AuthUserRoleServiceImpl extends CacheServiceImpl<AuthUserRoleDao, AuthUserRole> implements AuthUserRoleService {

}