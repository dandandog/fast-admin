package pers.dandandog.admin.controller;

import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pers.dandandog.admin.entity.AuthUser;
import pers.dandandog.admin.service.AuthRoleService;
import pers.dandandog.admin.service.AuthUserService;

/**
 * @author JohnnyLiu
 */
@Controller("/auth/user.faces")
public class AuthUserController extends FacesController {

    @Autowired
    private AuthUserService userService;

    @Autowired
    private AuthRoleService roleService;


    @Override
    public void onEntry() {
        putViewScope("user", null);
    }

    public LazyDataModel<AuthUser> getDataModel() {
        return null;
    }

    public void add() {
        AuthUser user = new AuthUser();
        putViewScope("user", user);
        putViewScope("roles", roleService.list());
    }


    public void edit() {
    }

    @MessageRequired(type = MessageType.SAVE)
    public void save() {
    }

    @MessageRequired(type = MessageType.DELETE)
    public void delete() {
    }


}
