package com.ibw.skylab.loyaltybackend.business.concretes;

import com.ibw.skylab.loyaltybackend.business.abstracts.UserService;
import com.ibw.skylab.loyaltybackend.core.utilities.results.DataResult;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.dataAccess.UserDao;
import com.ibw.skylab.loyaltybackend.entities.User;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.CreateUserDto;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.GetUserDto;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.UpdateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;

    @Override
    public Result addUser(CreateUserDto createUserDto) {
        return null;
    }

    @Override
    public DataResult<GetUserDto> getUserById(int userId) {
        return null;
    }

    @Override
    public DataResult<GetUserDto> getUserByMail(String schoolMail) {
        return null;
    }

    @Override
    public Result deleteUser(int userId) {
        return null;
    }

    @Override
    public DataResult<GetUserDto> updateUser(UpdateUserDto updateUserDto) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
