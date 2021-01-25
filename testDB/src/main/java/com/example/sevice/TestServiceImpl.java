package com.example.sevice;

import java.sql.Timestamp;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.mapper.TestMapper;

@Service
public class TestServiceImpl implements TestService {
	
	private Logger log = LoggerFactory.getLogger(TestServiceImpl.class);
	
	@Autowired
	private TestMapper testMapper;

	
	@Override
	public JSONArray getUser() {
		JSONArray jArr	= new JSONArray();
		JSONObject jObj	= null;
		Timestamp t 	= null;
		List<UserDto> userList	= testMapper.getUser();

		for (UserDto user : userList) {
			jObj = new JSONObject();
			
			t = user.getBirthday();
			
			jObj.put("id", user.getId());
			jObj.put("name", user.getName());
			jObj.put("location", user.getLocation());
			jObj.put("birthday", user.getBirthday());
			jArr.add(jObj);
		}
		
		return jArr;
	}

	@Override
	public int insertUser(UserDto user) {

		if(testMapper.getUserById(user.getId()) == null) {
			log.info("USER 입력완료!");
		}else {
			log.info("ID가 이미 존재합니다");
			
			return 0;
		}
		
		return testMapper.insertUser(user);
	}
	
	
	
	

}
