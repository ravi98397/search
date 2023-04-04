package com.music.search.trieImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.music.search.model.Node;

@Service
public class BasicTrie {
	private static int MAX_DEPTH = 40;
	public Node createTrie(List<Node> arr){
		System.out.println(arr.size());
		Node root = new Node(0l, "", "node");
		
		for(Node i: arr) {
			String nval = i.getValue();
			Node curr = root;
			for(int j=0; j < nval.length()-1 || j == MAX_DEPTH; j++) {
				String sub = nval.substring(0, j+1);
				HashMap<String, Node> child = curr.getChild();
				if(!child.containsKey(0+sub+"node")) {
					Node newNode = new Node(0, sub, "node");
					curr.addChild(newNode);
				}
				
			}
			curr.addChild(i);
		}
	return root;
	}
	
	public void traverse(Node root) {
		Node curr = root;
		for(String i: curr.getChild().keySet()) {
			traverse(curr.getChild().get(i));
		}
		System.out.println(curr.getValue() + ", " +curr.getType());
	}
	
	public void search(Node root, String term) {
		Node curr = root;
		for(String i: curr.getChild().keySet()) {
			traverse(curr.getChild().get(i));
		}
		System.out.println(curr.getValue() + ", " +curr.getType());
	}
}
