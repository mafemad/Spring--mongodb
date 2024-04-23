package com.projeto.springMongoDB.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projeto.springMongoDB.springmongo.DTO.AuthorDTO;
import com.projeto.springMongoDB.springmongo.DTO.CommentDTO;
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
		
		userRepo.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2024"), "partiu viagem", "Vou para caçapava, lessss go", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/04/2024"), "adoro comer sushi", "sushi e sashimi sao as melhores coisas",new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("boa viagem mano!", sdf.parse("25/03/2024"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("aproveite!", sdf.parse("22/03/2024"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("boa viagem mano!", sdf.parse("25/03/2024"), new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepo.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepo.save(maria);
		
		
	}

}
