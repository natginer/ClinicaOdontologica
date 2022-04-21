package com.example.clinica.entity;

import com.example.clinica.login.UserRoles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class UserRol implements UserDetails {

    @Id
    @SequenceGenerator(name= "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private int id;
    private String nombre;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRoles appUsuarioRoles;

    public UserRol(){

    }

    public UserRol(String nombre, String userName, String email, String password, UserRoles appUsuarioRoles) {
        this.nombre = nombre;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.appUsuarioRoles = appUsuarioRoles;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUsuarioRoles.name());
        return Collections.singletonList(grantedAuthority);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoles getAppUsuarioRoles() {
        return appUsuarioRoles;
    }

    public void setAppUsuarioRoles(UserRoles appUsuarioRoles) {
        this.appUsuarioRoles = appUsuarioRoles;
    }
}
