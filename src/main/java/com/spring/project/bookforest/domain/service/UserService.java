package com.spring.project.bookforest.domain.service;

import com.spring.project.bookforest.domain.entity.User;
import com.spring.project.bookforest.dto.UserInfoDto;
import com.spring.project.bookforest.dto.UserRegisterReqDto;
import com.spring.project.bookforest.dto.UserUpdateReqDto;
import com.spring.project.bookforest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void userRegister(UserRegisterReqDto requestDto){
        //DB에 이미 존재하는 회원 정보인지 확인
        if(userRepository.countByEmail(requestDto.getEmail())==0){
            userRepository.save(User.builder()
                    .email(requestDto.getEmail())
                    .name(requestDto.getName())
                    .password(requestDto.getPassword())
                    .phoneNumber(requestDto.getPhoneNumber())
                    .build());
        }
    }

    public UserInfoDto getUserInfo(String email){
        User user = userRepository.findByEmail(email);
        return entityToDto(user);
    }

    public UserInfoDto updateUserInfo(UserUpdateReqDto reqDto){
        User user=userRepository.findByEmail(reqDto.getEmail());

        return new UserInfoDto(user.getEmail(),user.getName(),user.getPassword(),user.getPhoneNumber(),
                user.getAddr1(),user.getAddr2(),user.getAddrCode(),
                user.getUClass(),user.getPurchaseAmount());
    }

    public boolean verifyToUpdate(String email,String password){
        User user = userRepository.findByEmail(email);
        return password.equals(user.getPassword());
    }

    private UserInfoDto entityToDto(User user){
        return new UserInfoDto(user.getEmail(),user.getName(),user.getPassword(),user.getPhoneNumber(),
                user.getAddr1(),user.getAddr2(),user.getAddrCode(),
                user.getUClass(),user.getPurchaseAmount());
    }
}
