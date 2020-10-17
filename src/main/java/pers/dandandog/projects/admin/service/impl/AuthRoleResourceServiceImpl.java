package pers.dandandog.projects.admin.service.impl;

import com.dandandog.framework.core.service.BaseServiceImpl;
import org.springframework.stereotype.Service;
import pers.dandandog.projects.admin.dao.AuthRoleResourceDao;
import pers.dandandog.projects.admin.entity.AuthRoleResource;
import pers.dandandog.projects.admin.service.AuthRoleResourceService;

/**
 * 系统角色资源关系表(AuthRoleResource)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service
public class AuthRoleResourceServiceImpl extends BaseServiceImpl<AuthRoleResourceDao, AuthRoleResource> implements AuthRoleResourceService {

}