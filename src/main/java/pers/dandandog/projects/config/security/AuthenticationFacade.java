package pers.dandandog.projects.config.security;

import com.dandandog.framework.common.components.security.IAuthenticationFacade;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public boolean isLogin() {
        return getAuthentication() instanceof UsernamePasswordAuthenticationToken;
    }

    @Override
    public Object getPrincipal() {
        return getAuthentication().getPrincipal();
    }

    @Override
    public String getUniqueId() {
        return getAuthentication().getName();
    }
}
