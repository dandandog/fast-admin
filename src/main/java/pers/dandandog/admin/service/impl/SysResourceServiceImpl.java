package pers.dandandog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dandandog.framework.core.entity.ITree;
import com.google.common.collect.Multimap;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.stereotype.Service;
import pers.dandandog.admin.config.model.TreeDataModel;
import pers.dandandog.admin.dao.SysResourceDao;
import pers.dandandog.admin.entity.SysResource;
import pers.dandandog.admin.service.SysResourceService;

import java.util.Arrays;
import java.util.Collection;

/**
 * 系统资源表(SysResource)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service("sysResourceService")
public class SysResourceServiceImpl extends ServiceImpl<SysResourceDao, SysResource> implements SysResourceService {

    private static final TreeDataModel<SysResource> treeDataModel = TreeDataModel.getInstance();

    @Override
    public CheckboxTreeNode getRootTree(boolean isExpand, SysResource... selected) {
        Multimap sources = treeDataModel.getValue(new QueryWrapper<SysResource>().lambda().orderByAsc(SysResource::getId, SysResource::getSeq));
        CheckboxTreeNode root = new CheckboxTreeNode(null, null);
        setTreeLeaf(root, sources, isExpand, selected);
        return root;
    }

    private void setTreeLeaf(TreeNode root, Multimap resourceMaps, boolean isExpand, SysResource... selected) {
        root.setExpanded(isExpand);
        root.setSelected(root.getData() != null && selected != null && Arrays.asList(selected).contains(root.getData()));
        if (root.getData() != null && !(root.getData() instanceof ITree)) {
            throw new RuntimeException("data is not extends TreeEntity");
        }
        Collection children = resourceMaps.removeAll(root.getData());
        if (children != null) {
            for (Object resource : children) {
                TreeNode node = new CheckboxTreeNode(((SysResource) resource).getType().getName(), resource, root);
                setTreeLeaf(node, resourceMaps, isExpand, selected);
            }
        }
    }
}