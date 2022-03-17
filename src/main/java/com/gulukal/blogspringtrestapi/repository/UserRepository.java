package com.gulukal.blogspringtrestapi.repository;


import com.gulukal.blogspringtrestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByEmail ( String email);
   Optional<User> findByUsernameOrEmail(String user, String email);
   Optional<User> findByUsername(String username);
   Boolean existsByUsername(String username);
   Boolean existsByEmail(String email);
}
