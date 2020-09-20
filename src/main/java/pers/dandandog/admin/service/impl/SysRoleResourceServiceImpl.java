package pers.dandandog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.dandandog.admin.dao.AuthRoleResourceDao;
import pers.dandandog.admin.entity.AuthRoleResource;
import pers.dandandog.admin.service.AuthRoleResourceService;
import org.springframework.stereotype.Service;

/**
 * 系统角色资源关系表(SysRoleResource)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service("sysRoleResourceService")
public class SysRoleResourceServiceImpl extends ServiceImpl<AuthRoleResourceDao, AuthRoleResource> implements AuthRoleResourceService {

}