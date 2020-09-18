package pers.dandandog.admin.controller;


import cn.hutool.core.util.EnumUtil;
import com.dandandog.framework.core.entity.BaseEntity;
import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.primefaces.model.DefaultTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pers.dandandog.admin.entity.SysResource;
import pers.dandandog.admin.entity.enums.ResourceType;
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
    public void onEntry() {
        dataTree(null);
        putViewScope("resource", null);
    }

    public void add() {
        SysResource resource = new SysResource();
        putViewScope("resource", resource);
        putViewScope("types", ResourceType.values());
    }

    public void edit() {
        String editId = getViewScope("editId");
        SysResource resource = resourceService.getById(editId);
        putViewScope("resource", resource);
    }

    @MessageRequired(type = MessageType.SAVE)
    public void save() {
        SysResource resource = getViewScope("resource");
        resourceService.save(resource);
    }

    @MessageRequired(type = MessageType.DELETE)
    public void delete() {
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