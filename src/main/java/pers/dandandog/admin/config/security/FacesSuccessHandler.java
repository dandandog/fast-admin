package pers.dandandog.admin.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FacesSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final String redirectUrl;

    public FacesSuccessHandler(String redirectUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(redirectUrl), () -> {
            return "'" + redirectUrl + "' is not a valid redirectUrl URL";
        });
        this.redirectUrl = redirectUrl;
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.sendRedirect(request.getServletContext().getContextPath() + redirectUrl);
    }
}
