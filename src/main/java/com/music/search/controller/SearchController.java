package com.music.search.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.music.search.model.Node;
import com.music.search.trieImpl.BasicTrie;

import fileOps.FileOperation;

@RestController
public class SearchController {
	
	@Autowired
	Node root;
	
	
	@GetMapping("/search")
	@CrossOrigin
	public TreeSet<Node> search(@RequestParam String term){
		return term.length() > 0 ? BasicTrie.search(root, term.toLowerCase()) : new TreeSet<Node>();
		
	}
	
}
