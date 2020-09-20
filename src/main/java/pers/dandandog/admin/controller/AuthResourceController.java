package pers.dandandog.admin.controller;


import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import com.dandandog.framework.faces.exception.MessageResolvableException;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.stereotype.Controller;
import pers.dandandog.admin.entity.AuthResource;
import pers.dandandog.admin.entity.enums.ResourceTarget;
import pers.dandandog.admin.entity.enums.ResourceType;
import pers.dandandog.admin.service.AuthResourceService;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 系统资源(SysResource)表控制层
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Controller("/auth/resource.faces")
public class AuthResourceController extends FacesController {

    /**
     * 服务对象
     */
    @Resource
    private AuthResourceService resourceService;

    @Override
    public void onEntry() {
        dataTree(null);
        putViewScope("selected", null);
        putViewScope("types", ResourceType.values());
        putViewScope("targets", ResourceTarget.values());
    }

    public void add() {
        AuthResource resource = new AuthResource();
        putViewScope("resource", resource);
    }

    public void addItem() {
        AuthResource resource = new AuthResource();
        putViewScope("resource", resource);
        putViewScope("types", ResourceType.values());
    }

    public void edit() {
        AuthResource selected = getViewScope("selected");
        AuthResource target = resourceService.getById(selected.getId());
        target = Optional.ofNullable(target).orElseThrow(() -> new MessageResolvableException("error", "notFound"));
        putViewScope("resource", target);
    }

    @MessageRequired(type = MessageType.SAVE)
    public void save() {
        AuthResource resource = getViewScope("resource");
        resourceService.saveOrUpdate(resource);
        onEntry();
    }

    @MessageRequired(type = MessageType.DELETE)
    public void delete() {
        AuthResource selected = getViewScope("selected");
        resourceService.removeById(selected.getId());
    }

    @MessageRequired(type = MessageType.DELETE)
    public void deleteBatch() {
        TreeNode[] mulSelected = getViewScope("mulSelected");
    }

    private void dataTree(AuthResource... selected) {
        Boolean isExpand = getViewScope("isExpand");
        putViewScope("resources", resourceService.getRootTree(isExpand == null ? false : isExpand, selected));
        putViewScope("mulSelected", new DefaultTreeNode());
    }

}