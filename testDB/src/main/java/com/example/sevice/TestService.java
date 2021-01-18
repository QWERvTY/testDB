package com.example.sevice;

import org.json.simple.JSONArray;
import com.example.dto.UserDto;

public interface TestService {
	
	public JSONArray getUser();
	
	public int insertUser(UserDto user); 

}
