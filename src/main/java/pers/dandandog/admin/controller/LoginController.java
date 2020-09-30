package pers.dandandog.admin.controller;

import cn.hutool.core.util.StrUtil;
import com.dandandog.framework.captcha.CaptchaFactory;
import com.dandandog.framework.captcha.exception.VerifyCaptchaException;
import com.dandandog.framework.captcha.model.ImageCaptcha;
import com.dandandog.framework.common.utils.SecurityUtil;
import com.dandandog.framework.faces.annotation.MessageRequired;
import com.dandandog.framework.faces.annotation.MessageType;
import com.dandandog.framework.faces.controller.FacesController;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import pers.dandandog.admin.entity.AuthUser;
import pers.dandandog.admin.service.AuthUserService;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;

/**
 * @author JohnnyLiu
 */
@Slf4j
@Controller("/login.faces")
public class LoginController extends FacesController {

    @Resource
    private CaptchaFactory captchaFactory;

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
            if (exception instanceof LockedException)
                errorMessages("error.userLocked", null);
            if (exception instanceof VerifyCaptchaException)
                errorMessages("error.captchaError", null);
            loadCaptcha();
        }
    }

    @MessageRequired(type = MessageType.OPERATION)
    public void sendEmail() {
        String email = getViewScope("email");
        AuthUser user = userService.findByEmail(email);

    }

    public void loadCaptcha() {
        ImageCaptcha captcha = captchaFactory.generate(ImageCaptcha.class, getRequest());
        StreamedContent captchaImg = DefaultStreamedContent.builder()
                .contentType("image/png").stream(() -> new ByteArrayInputStream(captcha.getImageBytes())).build();
        putViewScope("captcha", captchaImg);
    }

}
