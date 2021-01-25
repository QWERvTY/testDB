package com.example.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		
//		JSONArray jArr = null;
//
//		jArr = testService.getUser();
//		System.out.println(jArr.toJSONString());
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/getUser")
	public JSONArray getUser() {
		log.info("getUser!");
		JSONArray jArr = null;

		jArr = testService.getUser();
		System.out.println("jArr//"+jArr.toJSONString());
		return jArr;
	}
	
	@ResponseBody
	@RequestMapping("/insertUser")
	public int insertUser(@RequestParam Map<String, String> reqMap) {
		log.info(reqMap.toString());
		int num		= 0;
		String time	= reqMap.get("birthday");
		System.out.println(time);
		Timestamp timeDate = null;
		
		if (time != null && !"".equals(time)) {
			
			try {
				DateFormat dateFormat	= new SimpleDateFormat("yyyy-MM-dd");
				Date date				= dateFormat.parse(time);
				
				timeDate				= new Timestamp(date.getTime());
				System.out.println(timeDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		UserDto user = new UserDto(reqMap.get("id"), reqMap.get("name"), reqMap.get("location"), timeDate);
		
		num = testService.insertUser(user);
		System.out.println(num);
		return num;
	}
	
}
