package pers.dandandog.projects.admin.converter;

import com.dandandog.framework.faces.converter.GenericEnumConverter;
import org.springframework.stereotype.Component;
import pers.dandandog.projects.admin.entity.enums.UserGender;

@Component("userGenderConverter")
public class UserGenderConverter extends GenericEnumConverter<UserGender> {
}
