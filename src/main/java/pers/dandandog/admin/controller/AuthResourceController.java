package pers.dandandog.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dandandog.framework.core.entity.BaseEntity;
import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import com.dandandog.framework.faces.exception.MessageResolvableException;
import com.dandandog.framework.mapstruct.MapperRepo;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;
import org.springframework.stereotype.Controller;
import pers.dandandog.admin.entity.AuthResource;
import pers.dandandog.admin.entity.enums.ResourceTarget;
import pers.dandandog.admin.entity.enums.ResourceType;
import pers.dandandog.admin.model.vo.ResourceVo;
import pers.dandandog.admin.service.AuthResourceService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        putViewScope("isExpand", true);
        putViewScope("types", ResourceType.values());
        putViewScope("targets", ResourceTarget.values());
        putViewScope("sinSelected", null);
        putViewScope("mulSelected", new TreeNode[0]);
        putViewScope("parent", null);
        putViewScope("resources", resourceService.getRootTree(true, null));
    }

    public void add() {
        ResourceVo vo = new ResourceVo();
        putViewScope("resource", vo);
        putViewScope("rootTree", resourceService.getRootTree(true,
                new LambdaQueryWrapper<AuthResource>().ne(AuthResource::getType, ResourceType.BUTTON)));
    }

    public void edit() {
        AuthResource selected = getViewScope("sinSelected");
        AuthResource target = resourceService.getById(selected.getId());
        target = Optional.ofNullable(target).orElseThrow(() -> new MessageResolvableException("error", "dataNotFound"));
        ResourceVo vo = MapperRepo.mapTo(target, ResourceVo.class);
        putViewScope("resource", vo);
    }

    @MessageRequired(type = MessageType.SAVE)
    public void save() {
        ResourceVo vo = getViewScope("resource");
        AuthResource resource = MapperRepo.mapFrom(vo, AuthResource.class);
        resourceService.saveOrUpdate(resource);
        onEntry();
    }

    @MessageRequired(type = MessageType.DELETE)
    public void delete() {
        AuthResource selected = getViewScope("sinSelected");
        resourceService.removeById(selected.getId());
        onEntry();
    }

    @MessageRequired(type = MessageType.DELETE)
    public void deleteBatch() {
        TreeNode[] mulSelected = getViewScope("mulSelected");
        List<String> delIds = Arrays.stream(mulSelected)
                .map(TreeNode::getData)
                .map(o -> ((BaseEntity) o).getId())
                .collect(Collectors.toList());
        resourceService.removeByIds(delIds);
        onEntry();
    }

    public void onSelectParent(NodeSelectEvent event) {
        AuthResource resource = getViewScope("resource");
        String parentId = ((AuthResource) event.getTreeNode().getData()).getId();
        AuthResource parent = resourceService.getById(parentId);
        resource.setParentId(parentId);
        putViewScope("parent", parent);
    }
}