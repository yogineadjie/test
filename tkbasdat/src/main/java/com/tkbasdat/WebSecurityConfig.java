package com.tkbasdat;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		 .authorizeRequests()
		 .antMatchers("/").permitAll()
		 .antMatchers("/css/**").permitAll()
		 .antMatchers("/js/**").permitAll()
		 .antMatchers("/images/**").permitAll()
		 .antMatchers("/user/register").permitAll()
		 .antMatchers("/user/profil").hasAnyRole("NARASUMBER","ADMIN")
		 .antMatchers("/berita/create").hasRole("NARASUMBER")
		 .antMatchers("/berita/viewAllBerita").hasAnyRole("NARASUMBER","ADMIN")
		 .antMatchers("/berita/view/**").hasAnyRole("NARASUMBER","ADMIN")
		 .antMatchers("/berita/rating").hasAnyRole("NARASUMBER","ADMIN")
		 .antMatchers("/berita/comment").hasAnyRole("NARASUMBER","ADMIN")
		 .antMatchers("/polling/create").hasRole("NARASUMBER")
		 .antMatchers("/polling/view/**").hasAnyRole("NARASUMBER","ADMIN")
		 .anyRequest().authenticated()
		 .and()
		 .formLogin()
		 .loginPage("/login")
		 .permitAll()
		 .and()
		 .logout()
		 .permitAll();
	}
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.usersByUsernameQuery("select nama,password,enabled from narasumber where nama=?")
		.authoritiesByUsernameQuery("select nama, role from narasumber where nama=?");
	}
}
