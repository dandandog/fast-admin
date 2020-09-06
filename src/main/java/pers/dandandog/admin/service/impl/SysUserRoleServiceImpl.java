package pers.dandandog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.dandandog.admin.dao.SysUserRoleDao;
import pers.dandandog.admin.entity.SysUserRole;
import pers.dandandog.admin.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 系统用户角色关系表(SysUserRole)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {

}