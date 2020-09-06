package pers.dandandog.admin.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dandandog.framework.rest.controller.ApiController;
import com.dandandog.framework.rest.model.ApiResponse;
import pers.dandandog.admin.entity.SysUserRole;
import pers.dandandog.admin.service.SysUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 系统用户角色关系表(SysUserRole)表控制层
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@RestController
@RequestMapping("sys/user/role")
public class SysUserRoleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sysUserRole 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ApiResponse selectAll(Page<SysUserRole> page, SysUserRole sysUserRole) {
        return success(this.sysUserRoleService.page(page, new QueryWrapper<>(sysUserRole)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ApiResponse selectOne(@PathVariable Serializable id) {
        return success(this.sysUserRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUserRole 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ApiResponse insert(@RequestBody SysUserRole sysUserRole) {
        return success(this.sysUserRoleService.save(sysUserRole));
    }

    /**
     * 修改数据
     *
     * @param sysUserRole 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ApiResponse update(@RequestBody SysUserRole sysUserRole) {
        return success(this.sysUserRoleService.updateById(sysUserRole));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ApiResponse delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysUserRoleService.removeByIds(idList));
    }
}