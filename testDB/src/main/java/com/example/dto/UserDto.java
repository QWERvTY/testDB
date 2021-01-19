package com.example.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
	
	private String id, name, location;
	private Timestamp birthday;


}
