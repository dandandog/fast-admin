package pers.dandandog.projects.admin.service;

import com.dandandog.framework.core.service.ICacheService;
import pers.dandandog.projects.admin.entity.AuthResource;
import pers.dandandog.projects.admin.entity.AuthRole;

import java.util.List;

/**
 * 系统角色表(AuthRole)表服务接口
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
public interface AuthRoleService extends ICacheService<AuthRole> {


    void save(AuthRole role, List<AuthResource> resources);

}