package pers.dandandog.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dandandog.framework.core.config.pagination.QueryParams;
import com.dandandog.framework.core.config.pagination.QueryResult;
import com.dandandog.framework.mapstruct.MapperRepo;
import com.dandandog.framework.rest.controller.ApiController;
import com.dandandog.framework.rest.model.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.dandandog.admin.entity.SysResource;
import pers.dandandog.admin.model.params.SysResourceParamVo;
import pers.dandandog.admin.model.vo.SysResourceVo;
import pers.dandandog.admin.service.SysResourceService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 系统资源(SysResource)表控制层
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@RestController
@RequestMapping("sys/resource")
@Api(value = "系统资源Api", tags = {"SysResourceApi"})
public class SysResourceController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysResourceService sysResourceService;

    /**
     * 分页查询所有数据
     *
     * @param params 分页对象
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation(value = "分页查询所有数据", response = ApiResponse.class)
    public ApiResponse<QueryResult> selectAll(QueryParams<SysResourceParamVo> params) {
        Page<SysResource> page = new Page<>(params.getPage(), params.getSize());
        SysResource resource = MapperRepo.mapFrom(params.getFilter(), SysResource.class);
        page = this.sysResourceService.page(page, new QueryWrapper<>(resource));
        QueryResult result = new QueryResult(
                page.getCurrent(),
                page.getSize(),
                page.getPages(),
                page.getTotal(),
                MapperRepo.mapTo(page.getRecords(), SysResourceVo.class));
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
    public ApiResponse<SysResourceVo> selectOne(@PathVariable Serializable id) {
        SysResource resource = this.sysResourceService.getById(id);
        SysResourceVo vo = MapperRepo.mapTo(resource, SysResourceVo.class);
        return success(vo);
    }

    /**
     * 新增数据
     *
     * @param vo vo对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation(value = "新增数据系统资源", response = ApiResponse.class)
    public ApiResponse<Boolean> insert(@RequestBody SysResourceVo vo) {
        SysResource resource = MapperRepo.mapFrom(vo, SysResource.class);
        return success(this.sysResourceService.save(resource));
    }

    /**
     * 修改数据
     *
     * @param vo 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation(value = "修改数据", response = ApiResponse.class)
    public ApiResponse<Boolean> update(@RequestBody SysResourceVo vo) {
        SysResource resource = MapperRepo.mapFrom(vo, SysResource.class);
        return success(this.sysResourceService.updateById(resource));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation(value = "删除数据", response = ApiResponse.class)
    public ApiResponse<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysResourceService.removeByIds(idList));
    }
}