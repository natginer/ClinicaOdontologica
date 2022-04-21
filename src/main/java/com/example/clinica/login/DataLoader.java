package com.example.clinica.login;

import com.example.clinica.entity.UserRol;
import com.example.clinica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

   private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password1");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new UserRol("Nata", "natalia", "nat2@gmail.com",password, UserRoles.USER ));
        userRepository.save(new UserRol("Juan", "admin", "juan@gmail.com",password2, UserRoles.ADMIN ));

    }
}
