package pers.dandandog.admin.converter;


import com.dandandog.framework.faces.converter.GenericEntityConverter;
import org.springframework.stereotype.Component;
import pers.dandandog.admin.entity.AuthRole;
import pers.dandandog.admin.service.AuthRoleService;

import javax.annotation.Resource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@Component("authRoleConverter")
public class AuthRoleConverter extends GenericEntityConverter<AuthRole> {

    @Resource
    private AuthRoleService authRoleService;


    @Override
    protected AuthRole getEntity(FacesContext facesContext, UIComponent uiComponent, String id) {
        return authRoleService.getById(id);
    }
}
