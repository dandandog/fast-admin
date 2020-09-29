package pers.dandandog.admin.converter;

import com.dandandog.framework.faces.converter.GenericEnumConverter;
import org.springframework.stereotype.Component;
import pers.dandandog.admin.entity.enums.UserGender;

@Component("userGenderConverter")
public class UserGenderConverter extends GenericEnumConverter<UserGender> {
}
