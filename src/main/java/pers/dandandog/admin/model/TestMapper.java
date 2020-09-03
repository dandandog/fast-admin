package pers.dandandog.admin.model;

import com.dandandog.framework.mapstruct.StandardMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMapper extends StandardMapper<Test, TestVo> {


}
