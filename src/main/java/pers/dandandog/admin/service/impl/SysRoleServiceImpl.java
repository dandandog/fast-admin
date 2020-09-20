package pers.dandandog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.dandandog.admin.dao.AuthRoleDao;
import pers.dandandog.admin.entity.AuthRole;
import pers.dandandog.admin.service.AuthRoleService;
import org.springframework.stereotype.Service;

/**
 * 系统角色表(SysRole)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<AuthRoleDao, AuthRole> implements AuthRoleService {

}