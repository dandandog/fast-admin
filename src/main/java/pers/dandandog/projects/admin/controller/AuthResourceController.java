package pers.dandandog.projects.admin.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dandandog.framework.core.entity.BaseEntity;
import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import com.dandandog.framework.faces.exception.MessageResolvableException;
import com.dandandog.framework.mapstruct.MapperUtil;
import org.primefaces.model.TreeNode;
import org.springframework.stereotype.Controller;
import pers.dandandog.projects.admin.entity.AuthResource;
import pers.dandandog.projects.admin.entity.enums.ResourceTarget;
import pers.dandandog.projects.admin.entity.enums.ResourceType;
import pers.dandandog.projects.admin.service.AuthResourceService;
import pers.dandandog.projects.model.vo.ResourceVo;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        putViewScope("resource", null);
        putViewScope("resources", resourceService.getRootTree(true));
        putViewScope("sinSelected", null);
        putViewScope("mulSelected", new ArrayList<TreeNode>());
        putViewScope("types", ResourceType.values());
        putViewScope("targets", ResourceTarget.values());
    }

    public void add() {
        ResourceVo vo = new ResourceVo();
        putResourceView(vo);
    }

    @MessageRequired(type = MessageType.OPERATION, growl = false)
    public void edit() {
        AuthResource selected = getViewScope("sinSelected");
        AuthResource target = resourceService.getById(selected.getId());
        target = Optional.ofNullable(target).orElseThrow(() -> new MessageResolvableException("error", "dataNotFound"));
        ResourceVo vo = MapperUtil.map(target);
        putResourceView(vo);
    }

    @MessageRequired(type = MessageType.SAVE)
    public void save() {
        ResourceVo vo = getViewScope("resource");
        AuthResource resource = MapperUtil.map(vo);
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
        List<TreeNode> mulSelected = getViewScope("mulSelected");
        List<String> delIds = mulSelected.stream()
                .map(TreeNode::getData)
                .map(o -> ((BaseEntity) o).getId())
                .collect(Collectors.toList());
        resourceService.removeByIds(delIds);
        onEntry();
    }

    @MessageRequired(type = MessageType.OPERATION)
    public void onChangeStatus(AuthResource resource) {
        resourceService.updateById(resource);
        onEntry();
    }


    private void putResourceView(ResourceVo vo) {
        Wrapper<AuthResource> wrapper = new LambdaQueryWrapper<AuthResource>().ne(AuthResource::getType, ResourceType.BUTTON).orderByAsc(AuthResource::getSeq);
        putViewScope("resource", vo);
        putViewScope("rootTree", resourceService.getRootTree(wrapper, false, vo.getParent()));
    }
}