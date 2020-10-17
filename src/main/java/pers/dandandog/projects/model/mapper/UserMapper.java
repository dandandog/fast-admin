package pers.dandandog.projects.model.mapper;

import com.dandandog.framework.mapstruct.StandardMapper;
import org.mapstruct.Mapper;
import pers.dandandog.projects.admin.entity.AuthUser;
import pers.dandandog.projects.model.vo.UserVo;

@Mapper(componentModel = "spring")
public interface UserMapper extends StandardMapper<AuthUser, UserVo> {
}
