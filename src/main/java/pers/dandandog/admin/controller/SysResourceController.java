package pers.dandandog.admin.controller;


import com.dandandog.framework.core.entity.BaseEntity;
import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import com.google.common.collect.Lists;
import org.primefaces.model.LazyDataModel;
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
@Controller("sys/resource")
public class SysResourceController extends FacesController {

    /**
     * 服务对象
     */
    @Resource
    private SysResourceService sysResourceService;


    @Override
    public void onEntry() {
        putViewScope("name", "hello world");

    }

    /**
     * 分页查询所有数据
     */
    public LazyDataModel<SysResource> getDataModel() {
        return null;
    }

    public void add() {
        SysResource resource = new SysResource();
        putViewScope("resource", resource);
    }

    public void edit() {
        String editId = getViewScope("editId");
        SysResource resource = sysResourceService.getById(editId);
        putViewScope("resource", resource);
    }

    @MessageRequired(type = MessageType.SAVE)
    public void save() {
        SysResource resource = getViewScope("resource");
        sysResourceService.save(resource);
    }

    @MessageRequired(type = MessageType.DELETE)
    public void delete() {
        SysResource[] resources = getViewScope("selectedId");
        List<String> userIds = Lists.newArrayList(resources).stream().map(BaseEntity::getId).collect(Collectors.toList());
        sysResourceService.removeByIds(userIds);
    }
}