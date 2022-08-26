package lt.codeacademy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	 @Autowired
	    AuthenticationSuccessHandler successHandler;
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	            http
	            .authorizeRequests()
	            .antMatchers("/admin/**")  
	            .hasAuthority("ADMIN")
	            .anyRequest()
	            .authenticated()
	            .and()
	            .formLogin().successHandler(successHandler);  
	        }          
}
