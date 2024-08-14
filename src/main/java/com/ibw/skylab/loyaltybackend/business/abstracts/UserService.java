package com.ibw.skylab.loyaltybackend.business.abstracts;

import com.ibw.skylab.loyaltybackend.core.utilities.results.DataResult;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.CreateUserDto;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.GetUserDto;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.UpdateUserDto;
import org.apache.catalina.LifecycleState;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    Result addUser(CreateUserDto createUserDto);

    DataResult<GetUserDto> getUserById(int userId);

    DataResult<GetUserDto> getUserByEmail(String email);

    DataResult<GetUserDto> getUserByUsername(String username);

    Result deleteUser(int userId);

    DataResult<GetUserDto> updateUser(UpdateUserDto updateUserDto);

    DataResult<List<GetUserDto>> getAllUsers();


}
