package com.music.search.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NodeId implements Serializable {
	
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String value;
	
	@Column(nullable = false)
	private String type;

	public NodeId(long id, String value, String type) {
		super();
		this.id = id;
		this.value = value;
		this.type = type;
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



	@Override
	public boolean equals(Object obj) {
		NodeId node = (NodeId)obj;
		return (this.id + this.value + this.type).equals(node.getId() + node.getValue() + node.getType());
	}
	
}
