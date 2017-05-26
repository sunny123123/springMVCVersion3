package com.payne.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payne.entity.Board;
import com.payne.entity.Topic;
@Service
public class BoardService {
	
	@PersistenceContext
	private EntityManager entityManager ;
	public List<Board> getBoardsWithTopics(){
		String sql = "From Board b left join fetch b.topics";
		Query query = this.entityManager.createQuery(sql);
		List<Board> boards = query.getResultList();
		for(Board b:boards)
			System.out.println(b.getBoardName());
		return boards;
	}
}
