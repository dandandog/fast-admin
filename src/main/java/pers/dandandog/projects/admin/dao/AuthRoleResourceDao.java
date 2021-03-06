package pers.dandandog.projects.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.dandandog.projects.admin.entity.AuthRoleResource;

/**
 * 系统角色资源关系表(SysRoleResource)表数据库访问层
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Mapper
public interface AuthRoleResourceDao extends BaseMapper<AuthRoleResource> {

}