package pers.dandandog.admin.controller;

import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pers.dandandog.admin.entity.SysUser;
import pers.dandandog.admin.service.SysRoleService;
import pers.dandandog.admin.service.SysUserService;

/**
 * @author JohnnyLiu
 */
@Controller("/auth/user.faces")
public class SysUserController extends FacesController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;


    @Override
    public void onEntry() {
        putViewScope("user", null);
    }

    public LazyDataModel<SysUser> getDataModel() {
        return null;
    }

    public void add() {
        SysUser user = new SysUser();
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
