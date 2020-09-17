package pers.dandandog.admin.controller;

import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pers.dandandog.admin.entity.SysRole;
import pers.dandandog.admin.service.SysResourceService;
import pers.dandandog.admin.service.SysRoleService;

/**
 * @author JohnnyLiu
 */
@Controller("/auth/role.faces")
public class SysRoleController extends FacesController {
    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysResourceService resourceService;

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
        SysRole role = new SysRole();
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
    public void onChangeStatus(SysRole role) {
        roleService.updateById(role);
    }

}
