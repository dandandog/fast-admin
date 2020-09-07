package pers.dandandog.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dandandog.framework.rest.controller.ApiController;
import com.dandandog.framework.rest.model.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.dandandog.admin.entity.SysUser;
import pers.dandandog.admin.service.SysUserService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 系统用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-09-07 18:08:37
 */
@RestController
@RequestMapping("sys/user")
@Api(value = "系统用户表Api", tags = {"SysUserController"})
public class SysUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysUser 查询实体
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation(value = "分页查询所有数据", response = ApiResponse.class)
    public ApiResponse<QueryResult> selectAll(Page<SysUser> page, SysUser sysUser) {
        page = this.sysUserService.page(page, new QueryWrapper<>(sysUser));
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
        return success(this.sysUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation(value = "新增数据", response = ApiResponse.class)
    public ApiResponse insert(@RequestBody SysUser sysUser) {
        return success(this.sysUserService.save(sysUser));
    }

    /**
     * 修改数据
     *
     * @param sysUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation(value = "修改数据", response = ApiResponse.class)
    public ApiResponse update(@RequestBody SysUser sysUser) {
        return success(this.sysUserService.updateById(sysUser));
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
        return success(this.sysUserService.removeByIds(idList));
    }
}