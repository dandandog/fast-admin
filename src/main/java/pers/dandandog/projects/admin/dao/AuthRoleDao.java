package pers.dandandog.projects.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.dandandog.projects.admin.entity.AuthRole;

/**
 * 系统角色表(SysRole)表数据库访问层
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Mapper
public interface AuthRoleDao extends BaseMapper<AuthRole> {


}