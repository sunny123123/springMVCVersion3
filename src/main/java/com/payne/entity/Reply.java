package com.payne.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reply", catalog = "bbs")
public class Reply implements java.io.Serializable {

	// Fields

	private Integer replyId;
	private Topic topic;
	private User user;
	private String title;
	private String content;
	private Timestamp publishiTime;
	private Timestamp modifyTime;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** minimal constructor */
	public Reply(Topic topic, User user, String content,
			Timestamp publishiTime, Timestamp modifyTime) {
		this.topic = topic;
		this.user = user;
		this.content = content;
		this.publishiTime = publishiTime;
		this.modifyTime = modifyTime;
	}

	/** full constructor */
	public Reply(Topic topic, User user, String title, String content,
			Timestamp publishiTime, Timestamp modifyTime) {
		this.topic = topic;
		this.user = user;
		this.title = title;
		this.content = content;
		this.publishiTime = publishiTime;
		this.modifyTime = modifyTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "replyId", unique = true, nullable = false)
	public Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topicId", nullable = false)
	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "title", length = 50)
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

	@Column(name = "publishiTime", nullable = false, length = 19)
	public Timestamp getPublishiTime() {
		return this.publishiTime;
	}

	public void setPublishiTime(Timestamp publishiTime) {
		this.publishiTime = publishiTime;
	}

	@Column(name = "modifyTime", nullable = false, length = 19)
	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}