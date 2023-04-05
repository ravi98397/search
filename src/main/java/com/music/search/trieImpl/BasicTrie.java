package com.music.search.trieImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.music.search.model.Node;

@Service
public class BasicTrie {
	private static int MAX_DEPTH = 40;
	
	public Node createTrie(List<Node> arr){
		Node root = new Node(0l, "", "node");
		for(Node i: arr) {
			String nval = i.getValue();
			Node curr = root;
			for(int j=0; j < nval.length()-1 || j == MAX_DEPTH; j++) {
				String sub = nval.substring(0, j+1);
				HashMap<String, Node> child = curr.getChild();
				Node newNode = new Node(0, sub, "node");
				if(!child.containsKey(newNode.getKey())) {
					curr.addChild(newNode);
					curr.setCache(i);
				}
				curr.setCache(i);
				curr = curr.getChild().get(newNode.getKey());
			}
		}
	return root;
	}
	
	public void traverse(Node root) {
		Node curr = root;
		for(String i: curr.getChild().keySet()) {
			traverse(curr.getChild().get(i));
		}
		System.out.println(curr.getValue() + ", " +curr.getType() + ", " + curr.getCache().size());
	}
	
	public void search(Node root, String term) {
		Node curr = root;
		for(int i = 0; i < term.length(); i++) {
			Node next = new Node(0, term.substring(0, i+1), "node");
			if(curr.getChild().containsKey(next.getKey())) {
				curr = curr.getChild().get(next.getKey());
			}
			if(curr.getCache().size() == 0) {
				System.out.println(curr.getValue());
			}else {
				curr.getCache().forEach(node -> System.out.println(node.getValue()));
			}
		}
	}
}
