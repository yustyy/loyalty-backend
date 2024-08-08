package com.ibw.skylab.loyaltybackend.dataAccess;

import com.ibw.skylab.loyaltybackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
