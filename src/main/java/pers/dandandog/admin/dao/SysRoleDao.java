package pers.dandandog.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.dandandog.admin.entity.SysRole;

/**
 * 系统角色表(SysRole)表数据库访问层
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRole> {

}