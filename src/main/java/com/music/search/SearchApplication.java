package com.music.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.music.search.model.Node;
import com.music.search.repository.NodeRepository;
import com.music.search.trieImpl.BasicTrie;

@SpringBootApplication
public class SearchApplication {
	
	@Autowired
	NodeRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class, args);
		
	}
	
	//trying to create trie on teh startup
	
	@Bean
	public Node getRoot() {
		List<Node> list = repo.findAll();
		Node root = BasicTrie.createTrie(list);
		System.out.println("TreeCreated.....");
		return root;
	}

}