package lt.codeacademy.security;

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

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
   
		@Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

    
    @Autowired
    private UserAuthenticationSuccessHandler successHandler;
    


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
    	http
    	.cors().disable()
    	.csrf().disable()
        .authorizeRequests() 
        .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
        .antMatchers("/service").permitAll()
       // .antMatchers("/service/**").hasAnyAuthority("ROLE_ADMIN")
        .anyRequest().permitAll()
        .and()
        .formLogin()
        .permitAll()
        .successHandler(successHandler)
        .loginPage("/login")
        .permitAll()
        .loginProcessingUrl("/process-login")
        .permitAll()
        .defaultSuccessUrl("/service", true)
        .permitAll()
        .and()
        .logout().logoutSuccessUrl("/?logout=true")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID").permitAll()
      ;
    }


}
