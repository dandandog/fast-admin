package pers.dandandog.projects.model.params;

import com.dandandog.framework.mapstruct.StandardMapper;
import org.mapstruct.Mapper;
import pers.dandandog.projects.admin.entity.AuthResource;

@Mapper(componentModel = "spring")
public interface ResourceParamVoMapper extends StandardMapper<AuthResource, ResourceParamVo> {
}
