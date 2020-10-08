package pers.dandandog.admin.config.security;

import com.dandandog.framework.captcha.CaptchaServlet;
import com.dandandog.framework.captcha.config.properties.CaptchaProperties;
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

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PageProperties page;

    private final CaptchaProperties captcha;

    @Resource
    private UserDetailsService authUserService;


    @Autowired
    public SecurityConfig(PageProperties page, CaptchaProperties captcha) {
        this.page = page;
        this.captcha = captcha;
    }


    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN");
        auth.authenticationProvider(authenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        FacesFailureHandler facesFailureHandler = new FacesFailureHandler(page.getLoginFailed());
        FacesSuccessHandler facesSuccessHandler = new FacesSuccessHandler(page.getIndex());
        //http.addFilterBefore(new CaptchaAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.formLogin().loginPage(page.getLogin()).permitAll()
                .successHandler(facesSuccessHandler)
                .failureHandler(facesFailureHandler)
                .and().authorizeRequests().anyRequest().authenticated();
        http.logout().logoutSuccessUrl(page.getLogin());
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/javax.faces.resource/**");
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
    public ServletRegistrationBean<CaptchaServlet> getServletRegistrationBean() {  //一定要返回ServletRegistrationBean
        ServletRegistrationBean<CaptchaServlet> bean = new ServletRegistrationBean<>(new CaptchaServlet());     //放入自己的Servlet对象实例
        bean.addUrlMappings("/captcha/image.jpg");  //访问路径值
        return bean;
    }

}
