package com.example.clinica.repository;

import com.example.clinica.entity.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserRol, Integer> {

    @Query("SELECT u FROM UserRol u WHERE u.userName = ?1")
    Optional<UserRol> findByUserName(String userName);
}
