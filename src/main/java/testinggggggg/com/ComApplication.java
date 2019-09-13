package testinggggggg.com;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@SpringBootApplication
@EnableJpaAuditing
@EnableOAuth2Sso
public class ComApplication {
	
	protected void configure(HttpSecurity http) throws Exception {
		  http.antMatcher("/**").and().logout().logoutSuccessUrl("/").permitAll();
		}

	public static void main(String[] args) {
		SpringApplication.run(ComApplication.class, args);
	}

}
