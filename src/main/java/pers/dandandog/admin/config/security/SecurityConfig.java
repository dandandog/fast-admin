package pers.dandandog.admin.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.userDetailsService(userDetailsService());
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin().loginPage("/login.faces").permitAll()
                .failureForwardUrl("/login.faces?error=true");
        http.logout().logoutSuccessUrl("/login.faces");
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/javax.faces.resource/**");
    }

    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager result = new InMemoryUserDetailsManager();
        result.createUser(User.withDefaultPasswordEncoder().username("admin").password("password").authorities("ROLE_ADMIN").build());
        result.createUser(User.withDefaultPasswordEncoder().username("nyilmaz").password("qwe").authorities("ROLE_USER").build());
        return result;
    }
}
