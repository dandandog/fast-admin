package pers.dandandog.admin.service.impl;

import com.dandandog.framework.core.cache.BaseServiceImpl;
import org.springframework.stereotype.Service;
import pers.dandandog.admin.dao.AuthRoleResourceDao;
import pers.dandandog.admin.entity.AuthRoleResource;
import pers.dandandog.admin.service.AuthRoleResourceService;

/**
 * 系统角色资源关系表(AuthRoleResource)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service
public class AuthRoleResourceServiceImpl extends BaseServiceImpl<AuthRoleResourceDao, AuthRoleResource> implements AuthRoleResourceService {

}