package com.projeto.springMongoDB.springmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.springMongoDB.springmongo.DTO.UserDTO;
import com.projeto.springMongoDB.springmongo.DTO.UserDTO;
import com.projeto.springMongoDB.springmongo.entities.User;
import com.projeto.springMongoDB.springmongo.repository.UserRepository;
import com.projeto.springMongoDB.springmongo.service.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(),obj.getName(),obj.getEmail());
	}
}
