package pers.dandandog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.dandandog.admin.dao.SysUserDao;
import pers.dandandog.admin.entity.SysUser;
import pers.dandandog.admin.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 系统用户表(SysUser)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

}