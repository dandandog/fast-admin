package pers.dandandog.projects.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dandandog.framework.core.utils.MybatisUtil;
import com.dandandog.framework.mapstruct.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import pers.dandandog.projects.admin.entity.AuthResource;
import pers.dandandog.projects.model.vo.ResourceVo;

@Mapper(componentModel = "spring")
public interface ResourceVoMapper extends IMapper<AuthResource, ResourceVo> {


    @Override
    @Mapping(target = "parentNode", source = "parentId", qualifiedByName = "id2TreeNodeConverter")
    ResourceVo mapTo(AuthResource resource);

    @Override
    @Mapping(target = "parentId", expression = "java(resourceVo.getParent().getId())")
    AuthResource mapFrom(ResourceVo resourceVo);


    @Named("id2TreeNodeConverter")
    default TreeNode treeNode2IdConverter(String parentId) throws ClassNotFoundException {
        BaseMapper<AuthResource> baseMapper = MybatisUtil.getOneMappersByModelClass(AuthResource.class);
        AuthResource resource = baseMapper.selectById(parentId);
        return new CheckboxTreeNode(resource);
    }

}
