package com.infosys.learning.repository;

import com.infosys.learning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);

    User findByUserNameAndPassWord(String username,String password);
}
