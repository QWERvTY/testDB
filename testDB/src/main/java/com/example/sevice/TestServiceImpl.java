package com.example.sevice;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.mapper.TestMapper;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper testMapper;

	
	@Override
	public JSONArray getUser() {
		JSONArray jArr	= new JSONArray();
		JSONObject jObj	= null;
		List<UserDto> userList	= testMapper.getUser(); 

		for (UserDto user : userList) {
			jObj = new JSONObject();
			
			jObj.put("id", user.getId());
			jObj.put("name", user.getName());
			jObj.put("birthday", user.getBirthday());
			jObj.put("location", user.getLocation());
			jArr.add(jObj);
		}
		
		return jArr;
	}

	@Override
	public int insertUser(UserDto user) {
		return testMapper.insertUser(user);
	}
	
	
	
	

}
