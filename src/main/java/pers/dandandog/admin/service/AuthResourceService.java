package pers.dandandog.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.primefaces.model.CheckboxTreeNode;
import pers.dandandog.admin.entity.AuthResource;

/**
 * 系统资源表(SysResource)表服务接口
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
public interface AuthResourceService extends IService<AuthResource> {

    CheckboxTreeNode getRootTree(boolean isExpand, AuthResource... selected);

}