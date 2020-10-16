package pers.dandandog.admin.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
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

    TreeNode getRootTree(boolean isExpand, AuthResource... selected);

    TreeNode getRootTree(Wrapper<AuthResource> queryWrapper, boolean isExpand, AuthResource... selected);

}