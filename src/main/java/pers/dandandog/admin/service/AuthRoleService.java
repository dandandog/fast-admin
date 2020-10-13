package pers.dandandog.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.dandandog.admin.entity.AuthResource;
import pers.dandandog.admin.entity.AuthRole;

import java.util.List;

/**
 * 系统角色表(AuthRole)表服务接口
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
public interface AuthRoleService extends IService<AuthRole> {


    void save(AuthRole role, List<AuthResource> resources);

}