package com.example.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.TestRunner;
import com.example.dto.UserDto;
import com.example.sevice.TestService;

@Controller
public class TestController {
	private static Logger log = LoggerFactory.getLogger(TestRunner.class);
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/")
	public String test() {
		log.info("INDEX!");
		
		JSONArray jArr = null;

		jArr = testService.getUser();
		System.out.println(jArr.toJSONString());
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/getUser")
	public JSONArray getUser() {
		log.info("getUser!");
		JSONArray jArr = null;

		jArr = testService.getUser();
		System.out.println(jArr.toJSONString());
		return jArr;
	}
	
	@ResponseBody
	@RequestMapping("/insertUser")
	public int insertUser(@RequestParam Map<String, String> reqMap) {
		log.info(reqMap.toString());
		int num		= 0;
		String time	= reqMap.get("timestamp");
		Date date	= null;
		
		if (time != null || !"".equals(time)) {
			int year, month, day = 0;
			
			year	= Integer.parseInt(time.substring(0, 4));
			month	= Integer.parseInt(time.substring(4, 6));
			day		= Integer.parseInt(time.substring(6, 8));
			date	= new Date(year, month, day);
		}
		
		UserDto user = new UserDto(reqMap.get("id"), reqMap.get("name"), reqMap.get("location"), date);
		
		
		num = testService.insertUser(user);
		System.out.println(num);
		return num;
	}
	
}
