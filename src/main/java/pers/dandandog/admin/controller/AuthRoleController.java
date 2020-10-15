package pers.dandandog.admin.controller;

import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import com.dandandog.framework.faces.exception.MessageResolvableException;
import com.dandandog.framework.mapstruct.MapperRepo;
import org.springframework.stereotype.Controller;
import pers.dandandog.admin.entity.AuthResource;
import pers.dandandog.admin.entity.AuthRole;
import pers.dandandog.admin.model.vo.RoleVo;
import pers.dandandog.admin.service.AuthResourceService;
import pers.dandandog.admin.service.AuthRoleService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author JohnnyLiu
 */
@Controller("/auth/role.faces")
public class AuthRoleController extends FacesController {

    @Resource
    private AuthRoleService roleService;

    @Resource
    private AuthResourceService resourceService;

    @Override
    public void onEntry() {
        putViewScope("roles", roleService.list());
        putViewScope("role", null);
        putViewScope("sinSelected", null);
        putViewScope("mulSelected", new ArrayList<AuthRole>());
        putViewScope("rootTree", resourceService.getRootTree(true, null));
    }

    public void add() {
        RoleVo vo = new RoleVo();
        putViewScope("role", vo);
    }

    @MessageRequired(type = MessageType.OPERATION, growl = false)
    public void edit() {
        AuthRole selected = getViewScope("sinSelected");
        AuthRole target = roleService.getById(selected.getId());
        target = Optional.ofNullable(target).orElseThrow(() -> new MessageResolvableException("error", "dataNotFound"));
        RoleVo vo = MapperRepo.mapTo(target, RoleVo.class);
        putViewScope("role", vo);
        putViewScope("rootTree", resourceService.getRootTree(true, null, vo.getResources().toArray(new AuthResource[0])));
    }

    @MessageRequired(type = MessageType.SAVE)
    public void save() {
        RoleVo vo = getViewScope("role");
        AuthRole role = MapperRepo.mapFrom(vo, AuthRole.class);
        roleService.saveOrUpdate(role);
        onEntry();
    }

    @MessageRequired(type = MessageType.DELETE)
    public void delete() {
        AuthRole selected = getViewScope("sinSelected");
        roleService.removeById(selected.getId());
        onEntry();
    }

    @MessageRequired(type = MessageType.DELETE)
    public void deleteBatch() {
        List<AuthRole> selected = getViewScope("mulSelected");
        List<String> deleteIds = selected.stream().map(AuthRole::getId).collect(Collectors.toList());
        roleService.removeByIds(deleteIds);
        onEntry();
    }
}
