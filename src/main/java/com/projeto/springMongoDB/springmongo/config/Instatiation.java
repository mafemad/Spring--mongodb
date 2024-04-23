package com.projeto.springMongoDB.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projeto.springMongoDB.springmongo.entities.Post;
import com.projeto.springMongoDB.springmongo.entities.User;
import com.projeto.springMongoDB.springmongo.repository.PostRepository;
import com.projeto.springMongoDB.springmongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2024"), "partiu viagem", "Vou para caçapava, lessss go",maria);
		Post post2 = new Post(null, sdf.parse("21/04/2024"), "adoro comer sushi", "sushi e sashimi sao as melhores coisas",maria);
		
		userRepo.saveAll(Arrays.asList(maria,alex,bob));
		postRepo.saveAll(Arrays.asList(post1,post2));
		
		
	}

}
