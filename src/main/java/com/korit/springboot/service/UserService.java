package com.korit.springboot.service;


import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void createUser(CreateUserReqDto dto) {
        userMapper.insert(dto.toEntity());
    }
}
