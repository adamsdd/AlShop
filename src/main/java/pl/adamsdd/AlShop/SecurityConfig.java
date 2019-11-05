package pl.adamsdd.AlShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.inMemoryAuthentication()
//                .withUser("admin").password("admin").authorities("ROLE_USER", "ROLE_ADMIN")
//                .and()
//                .withUser("user").password("user").authorities("ROLE_USER");
//    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .csrf()
                .disable();
    }

/*    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/loginPage").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/alcohol").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/alcohol/new").access("hasRole('ROLE_ADMIN')")
                .and()
                    .formLogin().loginPage("/loginPage")
                    .defaultSuccessUrl("/alcohol")
                    .failureUrl("/loginPage?error")
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                    .logout().logoutSuccessUrl("/loginPage?logout");
    }*/
}
