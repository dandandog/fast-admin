package pers.dandandog.admin.controller;

import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pers.dandandog.admin.entity.AuthRole;
import pers.dandandog.admin.service.AuthResourceService;
import pers.dandandog.admin.service.AuthRoleService;

/**
 * @author JohnnyLiu
 */
@Controller("/auth/role.faces")
public class AuthRoleController extends FacesController {
    @Autowired
    private AuthRoleService roleService;

    @Autowired
    private AuthResourceService resourceService;

    @Override
    public void onEntry() {
        dataList();
        putViewScope("role", null);
        putViewScope("singleRole", null);
        putViewScope("selectedResources", new TreeNode[0]);

    }


    public void dataList() {
        putViewScope("roles", roleService.list());
    }

    public void add() {
        AuthRole role = new AuthRole();
        putViewScope("role", role);
    }


    public void edit() {

    }

    @MessageRequired(type = MessageType.SAVE)
    public void save() {
    }

    @MessageRequired(type = MessageType.DELETE)
    public void delete() {
    }

    @MessageRequired(type = MessageType.DELETE)
    public void deleteBatch() {
    }

    @MessageRequired(type = MessageType.OPERATION)
    public void onChangeStatus(AuthRole role) {
        roleService.updateById(role);
    }

}
