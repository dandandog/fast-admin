package pers.dandandog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.dandandog.admin.dao.SysResourceDao;
import pers.dandandog.admin.entity.SysResource;
import pers.dandandog.admin.service.SysResourceService;
import org.springframework.stereotype.Service;

/**
 * 系统资源表(SysResource)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service("sysResourceService")
public class SysResourceServiceImpl extends ServiceImpl<SysResourceDao, SysResource> implements SysResourceService {

}