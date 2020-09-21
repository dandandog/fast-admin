package pers.dandandog.admin.model.vo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dandandog.framework.core.entity.BaseEntity;
import com.dandandog.framework.core.utils.MybatisUtil;
import com.dandandog.framework.mapstruct.StandardMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import pers.dandandog.admin.entity.AuthResource;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ResourceVoMapper extends StandardMapper<AuthResource, ResourceVo> {


    @Override
    @Mapping(target = "parent", source = "parentId", qualifiedByName = "id2TreeNodeConverter")
    ResourceVo mapTo(AuthResource resource);

    @Override
    @Mapping(target = "parentId", source = "parent", qualifiedByName = "treeNode2IdConverter")
    AuthResource mapFrom(ResourceVo resourceVo);


    @Named("treeNode2IdConverter")
    default String treeNode2IdConverter(TreeNode node) {
        node = Optional.ofNullable(node).orElse(new CheckboxTreeNode());
        String parentId = null;
        if (node.getData() instanceof BaseEntity) {
            ((BaseEntity) node.getData()).getId();
        }
        return parentId;
    }

    @Named("id2TreeNodeConverter")
    default TreeNode treeNode2IdConverter(String parentId) throws ClassNotFoundException {
        BaseMapper<AuthResource> baseMapper = MybatisUtil.getMapper(AuthResource.class);
        AuthResource resource = baseMapper.selectById(parentId);
        return new CheckboxTreeNode(resource.getType().getTitle(), resource, null);
    }

}
