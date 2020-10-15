package pers.dandandog.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dandandog.framework.core.service.ICacheService;
import org.springframework.security.core.userdetails.UserDetailsService;
import pers.dandandog.admin.entity.AuthRole;
import pers.dandandog.admin.entity.AuthUser;

import java.util.List;

/**
 * 系统用户表(AuthUser)表服务接口
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
public interface AuthUserService extends ICacheService<AuthUser>, UserDetailsService {


    List<String> findRoleByUser(String userId);


    void save(AuthUser user, List<AuthRole> roles);


    AuthUser findByEmail(String email);


}