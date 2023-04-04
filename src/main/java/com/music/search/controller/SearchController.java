package com.music.search.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.search.model.Node;
import com.music.search.trieImpl.BasicTrie;

@RestController
public class SearchController {
	
	@GetMapping("/hello")
	public static void trytree() {
		System.out.println("hello");
		List<Node> arr = new ArrayList<Node>();
		String songarr[] = new String[]{"song1", "song2", "ring1", "ring2", "lksdj", "lksjdfl", "fjie", "jfosie", "oinveiow", "jfiowoe"};
		//String artarr[] = new String[]{"song1", "song2", "ring1", "ring2", "lksdj", "lksjdfl", "fjie", "jfosie", "oinveiow", "jfiowoe"};
		//String seararr[] = new String[]{"song1", "song2", "ring1", "ring2", "lksdj", "lksjdfl", "fjie", "jfosie", "oinveiow", "jfiowoe"};
		
		for(String s: songarr) {
			arr.add(new Node(arr.size()+1, s, "song"));
			arr.add(new Node(arr.size()+1, s, "artist"));
			arr.add(new Node(arr.size()+1, s, "sear"));
		}
		
		BasicTrie b = new BasicTrie();
		Node root = b.createTrie(arr);
		b.traverse(root);
	}
	
}
