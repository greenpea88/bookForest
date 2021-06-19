package com.spring.project.bookforest.domain.service;

import com.spring.project.bookforest.domain.entity.User;
import com.spring.project.bookforest.dto.*;
import com.spring.project.bookforest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void userRegister(UserRegisterReqDto requestDto){
        //TODO: 비밀번호 암호화
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
        user.updateInfo(reqDto.getPassword(),reqDto.getPhoneNumber(),reqDto.getAddr1(), reqDto.getAddr2(), reqDto.getAddrCode());
        userRepository.save(user);

        return new UserInfoDto(user.getEmail(),user.getName(),user.getPassword(),user.getPhoneNumber(),
                user.getAddr1(),user.getAddr2(),user.getAddrCode(),
                user.getUClass(),user.getPurchaseAmount());
    }

    public boolean verifyToUpdate(String email,String password){
        User user = userRepository.findByEmail(email);
        return password.equals(user.getPassword());
    }

    public UserLoginResDto login(UserLoginReqDto reqDto){
        //TODO: session 부여
        User user = userRepository.findByEmail(reqDto.getEmail());
        boolean passMatch = reqDto.getPassword().equals(user.getPassword());

        UserLoginResDto userLoginResDto = new UserLoginResDto();
        userLoginResDto.setSuccess(user != null && passMatch);
        userLoginResDto.setAdmin(user.getAdmin());

        return userLoginResDto;
    }

    public void incPurchase(String email,int price){
        User user = userRepository.findByEmail(email);
        user.setPurchaseAmount(user.getPurchaseAmount()+price);
        //등급 재책정
        user.userClass();
        userRepository.save(user);
    }

    public void decPurchase(String email,int price){
        User user = userRepository.findByEmail(email);
        user.setPurchaseAmount(user.getPurchaseAmount()-price);
        //등급재책정
        user.userClass();
        userRepository.save(user);
    }

    private UserInfoDto entityToDto(User user){
        return new UserInfoDto(user.getEmail(),user.getName(),user.getPassword(),user.getPhoneNumber(),
                user.getAddr1(),user.getAddr2(),user.getAddrCode(),
                user.getUClass(),user.getPurchaseAmount());
    }
}
