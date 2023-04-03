package com.music.search.model;

import java.util.HashMap;
import java.util.TreeSet;

import lombok.Data;

@Data
public class Node {
	long id;
	String name;
	String type;
	HashMap<String, Node> child;
	TreeSet<Node> cache;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public HashMap<String, Node> getChild() {
		return child;
	}

	public void setChild(HashMap<String, Node> child) {
		this.child = child;
	}

	public TreeSet<Node> getCache() {
		return cache;
	}

	public void setCache(Node ele) {
		if(this.cache.size() < 10) {
			this.cache.add(ele);
		}
		this.cache.add(ele);
		this.cache.pollLast();
	}

	public Node(long id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.child = new HashMap<String, Node>();
		this.cache = new TreeSet<Node>();
	}

	public Node(long id, String name, String type, HashMap<String, Node> child, TreeSet<Node> cache) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.child = child;
		this.cache = cache;
	}
	
}
