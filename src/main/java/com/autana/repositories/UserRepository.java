package com.autana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autana.domains.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
