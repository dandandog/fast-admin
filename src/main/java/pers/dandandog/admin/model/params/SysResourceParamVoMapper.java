package pers.dandandog.admin.model.params;

import com.dandandog.framework.mapstruct.StandardMapper;
import org.mapstruct.Mapper;
import pers.dandandog.admin.entity.SysResource;

@Mapper(componentModel = "spring")
public interface SysResourceParamVoMapper extends StandardMapper<SysResource, SysResourceParamVo> {
}
