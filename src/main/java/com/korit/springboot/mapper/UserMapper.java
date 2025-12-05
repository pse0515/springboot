package com.korit.springboot.mapper;


import com.korit.springboot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(UserEntity userEntity);

}
