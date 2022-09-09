package lt.codeacademy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lt.codeacademy.service.UserAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
   
    public PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    }
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserAuthenticationSuccessHandler successHandler;
    
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
        .withUser("user1@gmail.com").password(passwordEncoder().encode("user1Pass")).roles("USER")
        .and()
        .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
        .and()
        .withUser("admin@gmail.com").password(passwordEncoder().encode("12345")).roles("ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
    	http
    	//.csrf().disable()
        .authorizeRequests() 
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/service/**").hasAnyRole("USER","ADMIN")
        .antMatchers("/booking/**").hasAnyRole("USER","ADMIN")
        .anyRequest().permitAll()
        .and()
        .formLogin()
        .successHandler(successHandler)
        .loginPage("/login")
        .loginProcessingUrl("/process-login")
        .permitAll()
        .and()
        .logout().logoutSuccessUrl("/?logout=true")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID").permitAll()
        .and()
        .csrf()
        .disable();
        
        
       // .loginProcessingUrl("/process-login")
      //  .defaultSuccessUrl("/service", true)
      //  .permitAll()
      ;
    }

}
