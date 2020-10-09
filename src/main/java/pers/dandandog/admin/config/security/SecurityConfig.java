package pers.dandandog.admin.config.security;

import com.dandandog.framework.captcha.CaptchaServlet;
import com.dandandog.framework.captcha.CaptchaServletFactory;
import com.dandandog.framework.captcha.filter.CaptchaAuthenticationFilter;
import com.dandandog.framework.captcha.model.ImageCaptcha;
import com.dandandog.framework.faces.config.properties.PageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PageProperties page;

    @Resource
    private UserDetailsService authUserService;

    @Autowired
    public SecurityConfig(PageProperties page) {
        this.page = page;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN");
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        FacesFailureHandler facesFailureHandler = new FacesFailureHandler(page.getLoginFailed());
        FacesSuccessHandler facesSuccessHandler = new FacesSuccessHandler(page.getIndex());

        http.addFilterBefore(new CaptchaAuthenticationFilter((request, response, e) -> {
            try {
                facesFailureHandler.onAuthenticationFailure(request, response, new CaptchaErrorException(e.getMessage()));
            } catch (Exception ignored) {
            }
        }), UsernamePasswordAuthenticationFilter.class);
        http.formLogin().loginPage(page.getLogin()).permitAll()
                .successHandler(facesSuccessHandler)
                .failureHandler(facesFailureHandler)
                .and().authorizeRequests().anyRequest().authenticated();
        http.logout().logoutSuccessUrl(page.getLogin());
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/javax.faces.resource/**", "/captcha/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(authUserService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public ServletRegistrationBean<CaptchaServlet> getServletRegistrationBean(CaptchaServletFactory servletFactory) {
        CaptchaServlet captchaServlet = servletFactory.generate(ImageCaptcha.class);
        ServletRegistrationBean<CaptchaServlet> bean = new ServletRegistrationBean<>(captchaServlet);
        bean.addUrlMappings("/captcha/image.jpg");
        return bean;
    }

}
