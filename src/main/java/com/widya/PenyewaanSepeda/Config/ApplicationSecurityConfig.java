package com.widya.PenyewaanSepeda.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfig { //extends WebSecurityConfigurerAdapter {
    /*
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/register").permitAll()
                .antMatchers("/api/auth/**").hasRole("ADMIN")
                .antMatchers("/api/customer/index").hasRole("ADMIN")
                .antMatchers("/api/peminjaman/**").hasRole("ADMIN")
                .antMatchers("/api/sepeda/**").hasRole("ADMIN")
                .and()
                .httpBasic();
    }
   @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws  Exception{
        return super.authenticationManager();
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

*/
}
