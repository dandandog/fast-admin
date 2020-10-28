package pers.dandandog.projects.model.mapper;

import com.dandandog.framework.mapstruct.StandardMapper;
import com.dandandog.framework.mapstruct.qualifier.QualifierUrl;
import org.mapstruct.Mapper;
import pers.dandandog.projects.admin.entity.AuthUser;
import pers.dandandog.projects.model.vo.UserVo;

@Mapper(componentModel = "spring", uses = {QualifierUrl.class})
public interface UserMapper extends StandardMapper<AuthUser, UserVo> {
}
