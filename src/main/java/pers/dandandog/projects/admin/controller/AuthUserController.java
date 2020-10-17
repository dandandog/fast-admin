package pers.dandandog.projects.admin.controller;

import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import com.dandandog.framework.faces.exception.MessageResolvableException;
import com.dandandog.framework.mapstruct.MapperRepo;
import org.primefaces.model.LazyDataModel;
import org.springframework.stereotype.Controller;
import pers.dandandog.projects.model.data.PageDataModel;
import pers.dandandog.projects.admin.entity.AuthRole;
import pers.dandandog.projects.admin.entity.AuthUser;
import pers.dandandog.projects.admin.entity.enums.UserGender;
import pers.dandandog.projects.admin.entity.enums.UserState;
import pers.dandandog.projects.model.vo.UserVo;
import pers.dandandog.projects.admin.service.AuthRoleService;
import pers.dandandog.projects.admin.service.AuthUserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author JohnnyLiu
 */
@Controller("/auth/user.faces")
public class AuthUserController extends FacesController {

    @Resource
    private AuthUserService userService;

    @Resource
    private AuthRoleService roleService;

    @Override
    public void onEntry() {
        putViewScope("user", null);
        putViewScope("sigSelected", null);
        putViewScope("mulSelected", new ArrayList<AuthUser>());
        putViewScope("genders", UserGender.values());
        putViewScope("states", UserState.values());
    }

    public LazyDataModel<AuthUser> getDataModel() {
        return PageDataModel.getInstance(AuthUser.class);
    }

    public void add() {
        UserVo vo = new UserVo();
        findUserRole(vo);
        putViewScope("user", vo);
    }

    @MessageRequired(type = MessageType.OPERATION, growl = false)
    public void edit() {
        AuthUser selected = getViewScope("sigSelected");
        AuthUser target = userService.getById(selected.getId());
        target = Optional.ofNullable(target).orElseThrow(() -> new MessageResolvableException("error", "dataNotFound"));
        UserVo vo = MapperRepo.mapTo(target, UserVo.class);
        findUserRole(vo);
        putViewScope("user", vo);
    }

    @MessageRequired(type = MessageType.SAVE)
    public void save() {
        UserVo vo = getViewScope("user");
        AuthUser user = MapperRepo.mapFrom(vo, AuthUser.class);
        userService.save(user, vo.getRoleModel().getTarget());
    }

    @MessageRequired(type = MessageType.DELETE)
    public void delete() {
        AuthUser selected = getViewScope("sigSelected");
        userService.removeById(selected.getId());
    }

    @MessageRequired(type = MessageType.DELETE)
    public void deleteBatch() {
        List<AuthUser> selected = getViewScope("mulSelected");
        List<String> deleteIds = selected.stream().map(AuthUser::getId).collect(Collectors.toList());
        userService.removeByIds(deleteIds);
    }

    private void findUserRole(UserVo vo) {
        List<AuthRole> source = roleService.list();
        List<AuthRole> target = Optional.ofNullable(vo.getId()).map(userId -> {
            List<String> roleByUser = userService.findRoleByUser(userId);
            return source.stream().filter(role -> roleByUser.contains(role.getId()));
        }).orElse(Stream.empty()).collect(Collectors.toList());
        source.removeAll(target);
        vo.getRoleModel().setSource(source);
        vo.getRoleModel().setTarget(target);
    }
}