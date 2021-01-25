package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.dto.UserDto;

@Mapper
@Repository
public interface TestMapper {
	
	public List<UserDto> getUser();
	
	public UserDto getUserById(String id);
	
	public int insertUser(UserDto user); 

}
