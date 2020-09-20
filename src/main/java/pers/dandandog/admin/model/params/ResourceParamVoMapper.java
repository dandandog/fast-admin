package pers.dandandog.admin.model.params;

import com.dandandog.framework.mapstruct.StandardMapper;
import org.mapstruct.Mapper;
import pers.dandandog.admin.entity.AuthResource;

@Mapper(componentModel = "spring")
public interface ResourceParamVoMapper extends StandardMapper<AuthResource, ResourceParamVo> {
}
