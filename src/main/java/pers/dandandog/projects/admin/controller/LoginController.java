package pers.dandandog.projects.admin.controller;

import cn.hutool.core.util.StrUtil;
import com.dandandog.framework.common.utils.SecurityUtil;
import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import pers.dandandog.projects.config.security.CaptchaErrorException;
import pers.dandandog.projects.admin.entity.AuthUser;
import pers.dandandog.projects.admin.service.AuthUserService;

import javax.annotation.Resource;

/**
 * @author JohnnyLiu
 */
@Slf4j
@Controller("/login.faces")
public class LoginController extends FacesController {

    @Resource
    private AuthUserService userService;

    @Override
    public void onEntry() {
        if (SecurityUtil.isLogin()) {
            redirectInternal("/index");
        }
    }

    public void onLogin() {
        String isError = getRequestParameter("error");
        if (StrUtil.isNotEmpty(isError)) {
            Object exception = getRequest().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
            if (exception instanceof UsernameNotFoundException)
                errorMessages("error.userNotFound", null);
            else if (exception instanceof LockedException)
                errorMessages("error.accountLocked", null);
            else if (exception instanceof CaptchaErrorException)
                errorMessages("error.captchaError", null);
            else if (exception instanceof AccountExpiredException)
                errorMessages("error.accountExpired", null);
            else if (exception instanceof Exception)
                errorMessages("error.exception", null);
        }
    }

    @MessageRequired(type = MessageType.OPERATION)
    public void sendEmail() {
        String email = getViewScope("email");
        AuthUser user = userService.findByEmail(email);

    }
}
