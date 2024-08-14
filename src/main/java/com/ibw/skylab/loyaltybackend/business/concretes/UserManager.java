package com.ibw.skylab.loyaltybackend.business.concretes;

import com.ibw.skylab.loyaltybackend.business.abstracts.UserService;
import com.ibw.skylab.loyaltybackend.business.constants.UserMessages;
import com.ibw.skylab.loyaltybackend.core.utilities.results.*;
import com.ibw.skylab.loyaltybackend.dataAccess.UserDao;
import com.ibw.skylab.loyaltybackend.entities.User;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.CreateUserDto;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.GetUserDto;
import com.ibw.skylab.loyaltybackend.entities.dtos.user.UpdateUserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;

    private final ModelMapper modelMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Result addUser(CreateUserDto createUserDto) {
        if (createUserDto.getEmail().isEmpty()){
            return new ErrorResult(UserMessages.emailCannotBeEmpty);
        }

        if (createUserDto.getFirstName().isEmpty()){
            return new ErrorResult(UserMessages.firstNameCannotBeEmpty);
        }

        if (createUserDto.getLastName().isEmpty()){
            return new ErrorResult(UserMessages.lastNameCannotBeEmpty);
        }

        if (createUserDto.getPassword().isEmpty()){
            return new ErrorResult(UserMessages.passwordCannotBeEmpty);
        }

        if (createUserDto.getPhoneNumber().isEmpty()){
            return new ErrorResult(UserMessages.phoneNumberCannotBeEmpty);
        }

        if (createUserDto.getUsername().isEmpty()){
            return new ErrorResult(UserMessages.usernameCannotBeEmpty);
        }

        createUserDto.setPassword(passwordEncoder.encode(createUserDto.getPassword()));

        User user = modelMapper.map(createUserDto, User.class);

        user.setCreatedDate(new Date());
        userDao.save(user);

        return new SuccessResult(UserMessages.userAdded);
    }

    @Override
    public DataResult<GetUserDto> getUserById(int userId) {
        var result = userDao.findByIdAndDeleted(userId, false);

        if(!result.isPresent()){
            return new ErrorDataResult<>(UserMessages.userNotFound);
        }

        return new SuccessDataResult<>(modelMapper.map(result.get(), GetUserDto.class), UserMessages.userListed);
    }

    @Override
    public DataResult<GetUserDto> getUserByEmail(String email) {
        var result = userDao.findByEmailAndDeleted(email, false);

        if(!result.isPresent()){
            return new ErrorDataResult<>(UserMessages.userNotFound);
        }

        return new SuccessDataResult<>(modelMapper.map(result.get(), GetUserDto.class), UserMessages.userListed);


    }

    @Override
    public DataResult<GetUserDto> getUserByUsername(String username) {
        var result = userDao.findByUsernameAndDeleted(username, false);

        if(!result.isPresent()){
            return new ErrorDataResult<>(UserMessages.userNotFound);
        }

        return new SuccessDataResult<>(modelMapper.map(result.get(), GetUserDto.class), UserMessages.userListed);
    }

    @Override
    public Result deleteUser(int userId) {
        var user = userDao.findByIdAndDeleted(userId, false);

        if(!user.isPresent()){
            return new ErrorResult(UserMessages.userNotFound);
        }

        user.get().setDeleted(true);
        user.get().setDeletedDate(new Date());

        userDao.save(user.get());

        return new SuccessResult(UserMessages.userDeleted);
    }

    @Override
    public DataResult<GetUserDto> updateUser(UpdateUserDto updateUserDto) {
        var user = userDao.findByIdAndDeleted(updateUserDto.getId(), false);

        if(!user.isPresent()){
            return new ErrorDataResult<>(UserMessages.userNotFound);
        }

        var userToUpdate = user.get();
        userToUpdate.setFirstName(updateUserDto.getFirstName().isEmpty() ? userToUpdate.getFirstName() : updateUserDto.getFirstName());
        userToUpdate.setLastName(updateUserDto.getLastName().isEmpty() ? userToUpdate.getLastName() : updateUserDto.getLastName());
        userToUpdate.setEmail(updateUserDto.getEmail().isEmpty() ? userToUpdate.getEmail() : updateUserDto.getEmail());
        userToUpdate.setPhoneNumber(updateUserDto.getPhoneNumber().isEmpty() ? userToUpdate.getPhoneNumber() : updateUserDto.getPhoneNumber());
        userToUpdate.setBlockchainAddress(updateUserDto.getBlockchainAddress().isEmpty() ? userToUpdate.getBlockchainAddress() : updateUserDto.getBlockchainAddress());

        userToUpdate.setUpdatedDate(new Date());

        userDao.save(user.get());

        return new SuccessDataResult<>(modelMapper.map(user.get(), GetUserDto.class));
    }

    @Override
    public DataResult<List<GetUserDto>> getAllUsers() {
        var result = userDao.findAllByDeleted(false);

        if(!result.isPresent()){
            return new ErrorDataResult<>(UserMessages.usersNotFound);
        }

        List<GetUserDto> userList = new ArrayList<>();

        result.get().forEach(user -> {
            userList.add(GetUserDto.builder()
                            .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .phoneNumber(user.getPhoneNumber())
                    .username(user.getUsername())
                    .blockchainAddress(user.getBlockchainAddress())
                    .build());
        });

        return new SuccessDataResult<>(userList, UserMessages.usersListed);



    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userDao.findByUsernameAndDeleted(username, false);

        if(!user.isPresent()){
            throw new UsernameNotFoundException(UserMessages.userNotFound);
        }

        return user.get();
    }
}
