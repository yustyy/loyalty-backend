package com.ibw.skylab.loyaltybackend.dataAccess;

import com.ibw.skylab.loyaltybackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findByIdAndDeleted(int id, boolean deleted);

    Optional<User> findByUsernameAndDeleted(String username, boolean deleted);

    Optional<User> findByEmailAndDeleted(String email, boolean deleted);

    Optional<List<User>> findAllByDeleted(boolean deleted);

}
