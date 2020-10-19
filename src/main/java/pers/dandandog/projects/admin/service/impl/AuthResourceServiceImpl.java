package pers.dandandog.projects.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dandandog.framework.common.model.ITree;
import com.dandandog.framework.core.service.impl.BaseServiceImpl;
import com.google.common.collect.Multimap;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.stereotype.Service;
import pers.dandandog.projects.admin.dao.AuthResourceDao;
import pers.dandandog.projects.admin.entity.AuthResource;
import pers.dandandog.projects.admin.service.AuthResourceService;
import pers.dandandog.projects.model.data.TreeDataModel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * 系统资源表(AuthResource)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service
public class AuthResourceServiceImpl extends BaseServiceImpl<AuthResourceDao, AuthResource> implements AuthResourceService {


    @Override
    public TreeNode getRootTree(boolean isExpand, AuthResource... selected) {
        return getRootTree(Wrappers.emptyWrapper(), isExpand, selected);
    }

    @Override
    public TreeNode getRootTree(Wrapper<AuthResource> queryWrapper, boolean isExpand, AuthResource... selected) {
        TreeDataModel<AuthResource> treeDataModel = new TreeDataModel<>(AuthResource.class);
        queryWrapper = Optional.ofNullable(queryWrapper).orElse(new LambdaQueryWrapper<>());
        Multimap<AuthResource, AuthResource> sources = treeDataModel.getValue(queryWrapper);
        TreeNode root = new CheckboxTreeNode(null, null);
        setTreeLeaf(root, sources, isExpand, selected);
        return root;
    }

    private void setTreeLeaf(TreeNode root, Multimap<AuthResource, AuthResource> resourceMaps, boolean isExpand, AuthResource... selected) {
        root.setExpanded(isExpand);
        root.setSelected(root.getData() != null && selected != null && Arrays.asList(selected).contains(root.getData()));
        if (root.getData() != null && !(root.getData() instanceof ITree)) {
            throw new RuntimeException("data is not extends TreeEntity");
        }
        Collection<AuthResource> children = resourceMaps.removeAll(root.getData());
        if (children != null) {
            for (Object resource : children) {
                TreeNode node = new CheckboxTreeNode(resource, root);
                setTreeLeaf(node, resourceMaps, isExpand, selected);
            }
        }
    }
}