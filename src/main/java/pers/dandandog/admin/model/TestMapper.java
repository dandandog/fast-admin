package pers.dandandog.admin.model;

import com.dandandog.framework.mapstruct.StandardMapper;
import com.dandandog.framework.mapstruct.qualifier.QualifierUrl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = QualifierUrl.class)
public interface TestMapper extends StandardMapper<Test, TestVo> {


}
