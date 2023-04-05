package com.music.search.model;

import java.io.Serializable;
import java.util.Comparator;

public class NodeComparable implements Comparator<Node>, Serializable {

	@Override
	public int compare(Node o1, Node o2) {
		if(o1.getSelected() == o2.getSelected()) {
			if(o1.getValue().compareTo(o2.getValue()) == 0){
				return o1.getType().compareTo(o2.getType());
			}
			return o1.getValue().compareTo(o2.getValue());
		}
		return Long.compare(o1.getSelected(), o2.getSelected());
	}

}
