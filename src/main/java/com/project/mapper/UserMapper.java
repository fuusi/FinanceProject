package com.project.mapper;

import com.project.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> selectUserAll();
}
