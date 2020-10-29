package pers.dandandog.projects.model.mapper;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dandandog.framework.core.utils.MybatisUtil;
import com.dandandog.framework.mapstruct.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import pers.dandandog.projects.admin.entity.AuthResource;
import pers.dandandog.projects.admin.entity.AuthRole;
import pers.dandandog.projects.admin.entity.AuthRoleResource;
import pers.dandandog.projects.model.vo.RoleVo;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RoleVoMapper extends IMapper<AuthRole, RoleVo> {


    @Override
    @Mapping(target = "resourceNodes", source = "id", qualifiedByName = "treeNodeConverter")
    RoleVo mapTo(AuthRole role);

    @Named("treeNodeConverter")
    default TreeNode[] treeNodeConverter(String roleId) throws ClassNotFoundException {
        BaseMapper<AuthRoleResource> roleResourceMapper = MybatisUtil.getOneMappersByModelClass(AuthRoleResource.class);
        BaseMapper<AuthResource> resourceMapper = MybatisUtil.getOneMappersByModelClass(AuthResource.class);
        List<String> ids = roleResourceMapper.selectList(new LambdaQueryWrapper<AuthRoleResource>().eq(AuthRoleResource::getRoleId, roleId)).stream()
                .map(AuthRoleResource::getResId).collect(Collectors.toList());
        return CollUtil.isNotEmpty(ids) ? resourceMapper.selectBatchIds(ids).stream().map(CheckboxTreeNode::new).toArray(TreeNode[]::new) : new TreeNode[0];
    }
}
