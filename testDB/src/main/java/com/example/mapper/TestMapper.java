package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.UserDto;

@Mapper
public interface TestMapper {
	
	public List<UserDto> getUser();
	
	public int insertUser(UserDto user); 

}
