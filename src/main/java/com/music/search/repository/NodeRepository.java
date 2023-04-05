package com.music.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.search.model.Node;
import com.music.search.model.NodeId;

public interface NodeRepository extends JpaRepository<Node, NodeId> {

}
