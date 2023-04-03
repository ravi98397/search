package com.music.search.trieImpl;

import java.util.HashMap;

import com.music.search.model.Node;

public class BasicTrie {
	private static int MAX_DEPTH = 40;
	public HashMap<String, Node> createTrie(Node []arr){
		Node root = new Node(0l, "", "", new HashMap<String, Node>(), new Node[10]);
		
		for(Node i: arr) {
			String value = i.getName();
			char []carr = i.getName().toCharArray();
			Node curr = root;
			for(int c=0; c < carr.length; c++) {
				String sub = value.substring(0, c+1);
				HashMap<String, Node> child = curr.getChild();
				if(child.containsKey(sub)) {
					curr = curr.getChild().get(carr[c]);
				}
				
			}
		}
	return null;
	}
}
