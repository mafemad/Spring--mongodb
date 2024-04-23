package com.projeto.springMongoDB.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projeto.springMongoDB.springmongo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
