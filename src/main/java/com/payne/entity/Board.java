package com.payne.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Board entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "board", catalog = "bbs")
public class Board implements java.io.Serializable {

	// Fields

	private Integer boardId;
	private String boardName;
	private Integer parentId;
	private Set<Topic> topics = new HashSet<Topic>(0);

	// Constructors

	/** default constructor */
	public Board() {
	}

	/** minimal constructor */
	public Board(String boardName, Integer parentId) {
		this.boardName = boardName;
		this.parentId = parentId;
	}

	/** full constructor */
	public Board(String boardName, Integer parentId, Set<Topic> topics) {
		this.boardName = boardName;
		this.parentId = parentId;
		this.topics = topics;
	}

	// Property accessors
	@Id
	@Column(name = "boardId", unique = true, nullable = false)
	public Integer getBoardId() {
		return this.boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	@Column(name = "boardName", nullable = false, length = 50)
	public String getBoardName() {
		return this.boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@Column(name = "parentId", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "board")
	public Set<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

}