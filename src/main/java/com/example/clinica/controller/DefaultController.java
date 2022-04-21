package com.example.clinica.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class DefaultController {

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request, Authentication authentication) {
        Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) authentication.getAuthorities();
        for(GrantedAuthority authority: roles){
            if(authority.getAuthority().equalsIgnoreCase("ADMIN")){
                return "redirect:/index.html/";
            }
        };
        return "redirect:/indexUser.html/";

    }
}
