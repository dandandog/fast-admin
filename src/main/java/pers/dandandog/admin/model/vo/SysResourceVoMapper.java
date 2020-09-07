package pers.dandandog.admin.model.vo;

import com.dandandog.framework.mapstruct.StandardMapper;
import org.mapstruct.Mapper;
import pers.dandandog.admin.entity.SysResource;

@Mapper(componentModel = "spring")
public interface SysResourceVoMapper extends StandardMapper<SysResource, SysResourceVo> {
}
