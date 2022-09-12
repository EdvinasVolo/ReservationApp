package lt.codeacademy.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lt.codeacademy.service.UserAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserAuthenticationSuccessHandler successHandler;
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
		 auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
	      .dataSource(dataSource)
	      .usersByUsernameQuery("select username, password, enabled from users where username=?")
	        .authoritiesByUsernameQuery("select username, role from users where username=?");
	}
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                // .cors().disable()
                // .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/service/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                //.antMatchers("/service").permitAll()
                // .antMatchers("/service/**").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .successHandler(successHandler)
                .loginPage("/login")
                
                .loginProcessingUrl("/process-login")
                .permitAll()
                .defaultSuccessUrl("/service", true)
                .permitAll()
                .failureUrl("/login?error")
                .and()
                .logout().logoutSuccessUrl("/?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID").permitAll();
    }

}
