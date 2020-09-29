package pers.dandandog.admin.model.mapper;

import com.dandandog.framework.mapstruct.StandardMapper;
import org.mapstruct.Mapper;
import pers.dandandog.admin.entity.AuthUser;
import pers.dandandog.admin.model.vo.UserVo;

@Mapper(componentModel = "spring")
public interface UserMapper extends StandardMapper<AuthUser, UserVo> {
}
