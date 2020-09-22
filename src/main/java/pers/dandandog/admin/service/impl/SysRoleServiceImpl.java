package pers.dandandog.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.dandandog.admin.dao.AuthRoleDao;
import pers.dandandog.admin.entity.AuthResource;
import pers.dandandog.admin.entity.AuthRole;
import pers.dandandog.admin.entity.AuthRoleResource;
import pers.dandandog.admin.service.AuthRoleResourceService;
import pers.dandandog.admin.service.AuthRoleService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统角色表(SysRole)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<AuthRoleDao, AuthRole> implements AuthRoleService {

    @Resource
    private AuthRoleResourceService roleResourceService;


    @Override
    @Transactional
    public void save(AuthRole role, List<AuthResource> resources) {
        if (saveOrUpdate(role)) {
            roleResourceService.remove(new LambdaQueryWrapper<AuthRoleResource>().eq(AuthRoleResource::getRoleId, role.getId()));
            List<AuthRoleResource> resourceIds = CollUtil.emptyIfNull(resources).stream()
                    .map(resource -> new AuthRoleResource(role.getId(), resource.getId()))
                    .collect(Collectors.toList());
            if (resourceIds.size() != 0) {
                roleResourceService.saveBatch(resourceIds);
            }
        }
    }
}