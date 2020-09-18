package pers.dandandog.admin.controller;


import com.dandandog.framework.core.entity.BaseEntity;
import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import com.google.common.collect.Lists;
import org.primefaces.model.DefaultTreeNode;
import org.springframework.stereotype.Controller;
import pers.dandandog.admin.entity.SysResource;
import pers.dandandog.admin.service.SysResourceService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统资源(SysResource)表控制层
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Controller("/auth/resource.faces")
public class SysResourceController extends FacesController {

    /**
     * 服务对象
     */
    @Resource
    private SysResourceService resourceService;


    @Override
    public final void onEntry() {
        dataTree(null);
        putViewScope("resource", null);
    }

    public final void add() {
        SysResource resource = new SysResource();
        putViewScope("resource", resource);
    }

    public final void edit() {
        String editId = getViewScope("editId");
        SysResource resource = resourceService.getById(editId);
        putViewScope("resource", resource);
    }

    @MessageRequired(type = MessageType.SAVE)
    public final void save() {
        SysResource resource = getViewScope("resource");
        resourceService.save(resource);
    }

    @MessageRequired(type = MessageType.DELETE)
    public final void delete() {
        SysResource[] resources = getViewScope("selectedId");
        List<String> userIds = Lists.newArrayList(resources).stream().map(BaseEntity::getId).collect(Collectors.toList());
        resourceService.removeByIds(userIds);
    }

    private void dataTree(SysResource... selected) {
        Boolean isExpand = getViewScope("isExpand");
        putViewScope("resources", resourceService.getRootTree(isExpand == null ? false : isExpand, selected));
        putViewScope("selectedNode", new DefaultTreeNode());
    }

}