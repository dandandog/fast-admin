package pers.dandandog.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dandandog.framework.core.cache.BaseServiceImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.dandandog.admin.dao.AuthUserDao;
import pers.dandandog.admin.entity.AuthRole;
import pers.dandandog.admin.entity.AuthUser;
import pers.dandandog.admin.entity.AuthUserRole;
import pers.dandandog.admin.entity.enums.UserState;
import pers.dandandog.admin.service.AuthUserRoleService;
import pers.dandandog.admin.service.AuthUserService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 系统用户表(SysUser)表服务实现类
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Service("sysUserService")
public class AuthUserServiceImpl extends BaseServiceImpl<AuthUserDao, AuthUser> implements AuthUserService {

    @Resource
    private AuthUserRoleService userRoleService;

    @Resource
    private PasswordEncoder delegatingPasswordEncoder;

    @Override
    public List<String> findRoleByUser(String userId) {
        List<AuthUserRole> list = userRoleService.list(new LambdaQueryWrapper<AuthUserRole>().eq(AuthUserRole::getUserId, userId));
        return list.stream().map(AuthUserRole::getRoleId).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(AuthUser user, List<AuthRole> roles) {
        user.setPassword(delegatingPasswordEncoder.encode(user.getPassword()));
        if (saveOrUpdate(user)) {
            userRoleService.remove(new LambdaQueryWrapper<AuthUserRole>().eq(AuthUserRole::getUserId, user.getId()));
            List<AuthUserRole> userRoles = CollUtil.emptyIfNull(roles).stream()
                    .map(role -> new AuthUserRole(user.getId(), role.getId(), role.getCode()))
                    .collect(Collectors.toList());
            if (userRoles.size() != 0) {
                userRoleService.saveBatch(userRoles);
            }
        }
    }

    @Override
    public AuthUser findByEmail(String email) {
        return getOne(new LambdaQueryWrapper<AuthUser>().eq(AuthUser::getEmail, email));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = getOne(new LambdaQueryWrapper<AuthUser>().eq(AuthUser::getUsername, username));
        user = Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException("username not found"));
        List<AuthUserRole> userRoles = userRoleService.list(new LambdaQueryWrapper<AuthUserRole>().eq(AuthUserRole::getUserId, user.getId()));
        List<SimpleGrantedAuthority> roles = userRoles.stream().map(authUserRole -> new SimpleGrantedAuthority("ROLE_" + authUserRole.getRoleCode())).collect(Collectors.toList());

        return new User(user.getUsername(), user.getPassword(), !user.getDel(),
                user.getExpiredTime().isAfter(LocalDateTime.now()),
                !UserState.INACTIVATED.equals(user.getState()),
                !UserState.FREEZE.equals(user.getState()), roles);
    }
}