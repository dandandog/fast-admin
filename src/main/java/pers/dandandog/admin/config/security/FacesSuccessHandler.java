package pers.dandandog.admin.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FacesSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public FacesSuccessHandler() {

    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("Success");


        super.onAuthenticationSuccess(request, response, authentication);
    }
}
