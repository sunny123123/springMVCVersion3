package com.payne.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "topic", catalog = "bbs")
public class Topic implements java.io.Serializable {

	// Fields

	private Integer topicId;
	private Board board;
	private User user;
	private String title;
	private String content;
	private Timestamp publishTime;
	private Timestamp modifyTime;
	private Set<Reply> replies = new HashSet<Reply>(0);

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(Board board, User user, String title, String content,
			Timestamp publishTime, Timestamp modifyTime) {
		this.board = board;
		this.user = user;
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
		this.modifyTime = modifyTime;
	}

	/** full constructor */
	public Topic(Board board, User user, String title, String content,
			Timestamp publishTime, Timestamp modifyTime, Set<Reply> replies) {
		this.board = board;
		this.user = user;
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
		this.modifyTime = modifyTime;
		this.replies = replies;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "topicId", unique = true, nullable = false)
	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "boardId", nullable = false)
	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "title", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false, length = 1000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "publishTime", nullable = false, length = 19)
	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "modifyTime", nullable = false, length = 19)
	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "topic")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

}