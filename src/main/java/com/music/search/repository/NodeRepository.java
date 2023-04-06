package com.music.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.music.search.model.Node;
import com.music.search.model.NodeId;


@Service
public interface NodeRepository extends JpaRepository<Node, NodeId> {

}
