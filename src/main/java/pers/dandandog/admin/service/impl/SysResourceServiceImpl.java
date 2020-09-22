package pers.dandandog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dandandog.framework.core.entity.ITree;
import com.google.common.collect.Multimap;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.stereotype.Service;
import pers.dandandog.admin.config.model.TreeDataModel;
import pers.dandandog.admin.dao.AuthResourceDao;
import pers.dandandog.admin.entity.AuthResource;
import pers.dandandog.admin.service.AuthResourceService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * 系统资源表(SysResource)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<AuthResourceDao, AuthResource> implements AuthResourceService {


    @Override
    public TreeNode getRootTree(boolean isExpand, LambdaQueryWrapper<AuthResource> queryWrapper, AuthResource... selected) {
        TreeDataModel<AuthResource> treeDataModel = new TreeDataModel<>(AuthResource.class);
        queryWrapper = Optional.ofNullable(queryWrapper).orElse(new LambdaQueryWrapper<>());
        queryWrapper.orderByAsc(AuthResource::getSeq);
        Multimap sources = treeDataModel.getValue(queryWrapper);
        TreeNode root = new CheckboxTreeNode(null, null);
        setTreeLeaf(root, sources, isExpand, selected);
        return root;
    }

    private void setTreeLeaf(TreeNode root, Multimap resourceMaps, boolean isExpand, AuthResource... selected) {
        root.setExpanded(isExpand);
        root.setSelected(root.getData() != null && selected != null && Arrays.asList(selected).contains(root.getData()));
        if (root.getData() != null && !(root.getData() instanceof ITree)) {
            throw new RuntimeException("data is not extends TreeEntity");
        }
        Collection children = resourceMaps.removeAll(root.getData());
        if (children != null) {
            for (Object resource : children) {
                TreeNode node = new CheckboxTreeNode(resource, root);
                setTreeLeaf(node, resourceMaps, isExpand, selected);
            }
        }
    }
}