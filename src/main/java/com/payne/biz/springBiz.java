package com.payne.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payne.service.BoardService;

@Component
public class springBiz {
	@Autowired
	BoardService boardService;
	public void getBoards(){
		boardService.getBoardsWithTopics();
	}
	public void insertTopic(){
		boardService.insertTopic();
	}
}
