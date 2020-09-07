package pers.dandandog.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dandandog.framework.core.config.pagination.QueryResult;
import com.dandandog.framework.rest.controller.ApiController;
import com.dandandog.framework.rest.model.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.dandandog.admin.entity.SysRoleResource;
import pers.dandandog.admin.service.SysRoleResourceService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 系统角色资源关系表(SysRoleResource)表控制层
 *
 * @author makejava
 * @since 2020-09-07 18:08:37
 */
@RestController
@RequestMapping("sys/role/resource")
@Api(value = "系统角色资源关系表Api", tags = {"SysRoleResourceController"})
public class SysRoleResourceController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleResourceService sysRoleResourceService;

    /**
     * 分页查询所有数据
     *
     * @param page            分页对象
     * @param sysRoleResource 查询实体
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation(value = "分页查询所有数据", response = ApiResponse.class)
    public ApiResponse<QueryResult> selectAll(Page<SysRoleResource> page, SysRoleResource sysRoleResource) {
        page = this.sysRoleResourceService.page(page, new QueryWrapper<>(sysRoleResource));
        QueryResult result = new QueryResult(
                page.getCurrent(),
                page.getSize(),
                page.getPages(),
                page.getTotal(),
                page.getRecords());
        return success(result);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation(value = "通过主键查询单条数据", response = ApiResponse.class)
    public ApiResponse selectOne(@PathVariable Serializable id) {
        return success(this.sysRoleResourceService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRoleResource 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation(value = "新增数据", response = ApiResponse.class)
    public ApiResponse insert(@RequestBody SysRoleResource sysRoleResource) {
        return success(this.sysRoleResourceService.save(sysRoleResource));
    }

    /**
     * 修改数据
     *
     * @param sysRoleResource 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation(value = "修改数据", response = ApiResponse.class)
    public ApiResponse update(@RequestBody SysRoleResource sysRoleResource) {
        return success(this.sysRoleResourceService.updateById(sysRoleResource));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation(value = "删除数据", response = ApiResponse.class)
    public ApiResponse delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysRoleResourceService.removeByIds(idList));
    }
}