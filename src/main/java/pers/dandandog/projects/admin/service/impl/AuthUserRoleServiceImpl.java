package pers.dandandog.projects.admin.service.impl;

import com.dandandog.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import pers.dandandog.projects.admin.dao.AuthUserRoleDao;
import pers.dandandog.projects.admin.entity.AuthUserRole;
import pers.dandandog.projects.admin.service.AuthUserRoleService;

/**
 * 系统用户角色关系表(AuthUserRole)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service
public class AuthUserRoleServiceImpl extends BaseServiceImpl<AuthUserRoleDao, AuthUserRole> implements AuthUserRoleService {

}