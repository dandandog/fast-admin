package pers.dandandog.admin.model.vo;

import com.dandandog.framework.mapstruct.StandardMapper;
import org.mapstruct.Mapper;
import pers.dandandog.admin.entity.AuthResource;

@Mapper(componentModel = "spring")
public interface ResourceVoMapper extends StandardMapper<AuthResource, ResourceVo> {
}
