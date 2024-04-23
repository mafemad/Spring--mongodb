package com.projeto.springMongoDB.springmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.springMongoDB.springmongo.entities.Post;
import com.projeto.springMongoDB.springmongo.repository.PostRepository;
import com.projeto.springMongoDB.springmongo.service.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
}