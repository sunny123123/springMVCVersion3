package com.payne.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void insertTopic(){
		String sql = "insert into topic(title,content,publishTime,modifyTime,uId,boardId) values(?,?,?,?,?,?)";
		Query query = this.entityManager.createNativeQuery(sql);
		query.setParameter(1, "abc1");
		query.setParameter(2, "how to learn");
		query.setParameter(3, new Timestamp(new Date().getTime()));
		query.setParameter(4, new Timestamp(new Date().getTime()));
		query.setParameter(5, 2);
		query.setParameter(6, 4);
		query.executeUpdate();
		query.setParameter(1, "abc2");
		query.setParameter(2, "how to learn");
		query.setParameter(3, new Timestamp(new Date().getTime()));
		query.setParameter(4, new Timestamp(new Date().getTime()));
		query.setParameter(5, 2);
		query.setParameter(6, 4);
		query.executeUpdate();
		
	}
}
