package pers.dandandog.admin.service.impl;

import com.dandandog.framework.core.service.BaseServiceImpl;
import com.dandandog.framework.core.service.CacheServiceImpl;
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
public class AuthRoleResourceServiceImpl extends CacheServiceImpl<AuthRoleResourceDao, AuthRoleResource> implements AuthRoleResourceService {

}