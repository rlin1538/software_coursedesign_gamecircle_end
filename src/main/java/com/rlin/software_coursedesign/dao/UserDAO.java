package com.rlin.software_coursedesign.dao;

import com.rlin.software_coursedesign.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUserName(String username);

    User getByUserNameAndUserPassword(String username,String password);
}
