package com.hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.entity.User;
import com.hibernate.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository re;
	
	@Override
	public List<User> selectUserList()
	{
		return (List<User>) re.findAll();
	}
	
	@Override
	public Optional<User> selectUser(long userNo)
	{
		return re.findById(userNo);
	}
	
	@Override
	public void insertUser(User user)
	{
		re.save(user);
	}
	
	@Override
	public void updateUser(User user)
	{
		User u = re.findByEmail(user.getEmail());
		u.setName(user.getName()); // 사용자로부터 입력 받은 name값 넣어줌
		
		re.save(u);
	}
	
	@Override
	public void deleteUser(Long id)
	{
		re.deleteById(id);
	}
}
