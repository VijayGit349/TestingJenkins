package testinggggggg.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import testinggggggg.com.service.ServInterface;

import javax.annotation.Resource;

@Configuration
@EnableResourceServer

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
private AuthenticationManager authenticationManager;
	
	protected void configure(HttpSecurity http)throws Exception{
		http.requestMatchers().and().authorizeRequests().anyRequest().authenticated().and().
		formLogin().permitAll();
	}
	
	
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.parentAuthenticationManager(authenticationManager).inMemoryAuthentication().withUser("vijay")
		.password("vijay").roles("admin");
	}
	
}

