package com.music.search.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Entity
@IdClass(NodeId.class)
@Data
public class Node implements Serializable{
	
	@Id
	private long id;
	
	@Id
	private String value;
	
	@Id
	private String type;
	private long searched;  //stating no of time this text is inserted in text box
	private long selected;  //no of times anything is selected
	private HashMap<String, Node> child;
	private TreeSet<Node> cache;
	
	public Node(long id, String value, String type) {
		super();
		this.id = id;
		this.value = value;
		this.type = type;
		this.child = new HashMap<String, Node>();
		this.cache = new TreeSet<Node>(new NodeComparable());
	}

	public Node(long id, String value, String type, HashMap<String, Node> child, TreeSet<Node> cache) {
		super();
		this.id = id;
		this.value = value;
		this.type = type;
		this.child = child;
		this.cache = cache;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSearched() {
		return searched;
	}

	public void setSearched(long searched) {
		this.searched = searched;
	}

	public long getSelected() {
		return selected;
	}

	public void setSelected(long selected) {
		this.selected = selected;
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

	public void setCache(TreeSet<Node> cache) {
		this.cache = cache;
	}

	public String getKey() {
		return this.id + this.value + this.type;
	}
	
	public void addChild(Node node) {
		this.child.put(node.getKey(), node);
	}


	public void setCache(Node ele) {
		if(this.cache.size() > 10) {
			System.out.println("it rannnnnnnnnnnn");
			this.cache.pollLast();
		}
		this.cache.add(ele);
	}

}
