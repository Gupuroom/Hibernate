package com.hibernate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.entity.User;
import com.hibernate.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController
{
	
	@Autowired
	UserService userService;
	
	// 전체 조회
	@GetMapping("/selectAll")
	public List<User> getUserList()
	{
		return userService.selectUserList();
	}
	
	// 특정 조회
	@GetMapping("/select")
	public Optional<User> getUser(@RequestParam("userNo") long userNo)
	{
		return userService.selectUser(userNo);
	}
	
	// 삽입
	@PostMapping("/insert")
	public void insertUser(@RequestBody User user)
	{
		userService.insertUser(user);
	}
	
	// 수정
	// TODO: JPA로 구현하는 법 알아보자
	@PostMapping("/update")
	public void updateUser(@RequestBody User user)
	{
		userService.updateUser(user);
	}
	
	// 삭제
	@GetMapping("/delete")
	public void deleteUser(@RequestParam("userNo") Long userNo)
	{
		userService.deleteUser(userNo);
	}
}