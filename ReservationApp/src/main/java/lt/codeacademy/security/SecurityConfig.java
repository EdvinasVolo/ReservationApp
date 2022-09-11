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
        .antMatchers("/service/**")   .permitAll()
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
        .and()
        .csrf()
        .disable();
        
        
        
      //  .permitAll()
      ;
    }


}
