package pers.dandandog.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dandandog.framework.core.service.ICacheService;
import org.primefaces.model.TreeNode;
import pers.dandandog.admin.entity.AuthResource;

/**
 * 系统资源表(AuthResource)表服务接口
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
public interface AuthResourceService extends ICacheService<AuthResource> {

    TreeNode getRootTree(boolean isExpand, LambdaQueryWrapper<AuthResource> queryWrapper, AuthResource... selected);

}