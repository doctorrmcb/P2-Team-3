package com.revature.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Author - Robert Li
 */

@Entity
@Table(name = "Threads")
public class Thread {

	
	@Id
	@SequenceGenerator(name = "THREADID_SEQ", sequenceName = "thread_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "THREADID_SEQ")
	@Column(name = "THREAD_ID")
	private int threadID;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User posted_by;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name = "post_date")
	private LocalDate postDate;
	
	@Column(name = "post_time")
	private LocalTime postTime;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name = "is_sticky")
	private boolean isSticky;

	public int getThreadID() {
		return threadID;
	}

	public void setThreadID(int threadID) {
		this.threadID = threadID;
	}

	public User getPosted_by() {
		return posted_by;
	}

	public void setPosted_by(User posted_by) {
		this.posted_by = posted_by;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public LocalDate getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	public LocalTime getPostTime() {
		return postTime;
	}

	public void setPostTime(LocalTime postTime) {
		this.postTime = postTime;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public boolean isSticky() {
		return isSticky;
	}

	public void setSticky(boolean isSticky) {
		this.isSticky = isSticky;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + (isSticky ? 1231 : 1237);
		result = prime * result + ((postDate == null) ? 0 : postDate.hashCode());
		result = prime * result + ((postTime == null) ? 0 : postTime.hashCode());
		result = prime * result + threadID;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thread other = (Thread) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (isSticky != other.isSticky)
			return false;
		if (postDate == null) {
			if (other.postDate != null)
				return false;
		} else if (!postDate.equals(other.postDate))
			return false;
		if (postTime == null) {
			if (other.postTime != null)
				return false;
		} else if (!postTime.equals(other.postTime))
			return false;
		if (threadID != other.threadID)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Threads [threadID=" + threadID + ", title=" + title + ", contents=" + contents + ", postDate="
				+ postDate + ", postTime=" + postTime + ", topic=" + topic + ", isSticky=" + isSticky + "]";
	}

	public Thread(int threadID, User posted_by, String title, String contents, LocalDate postDate, LocalTime postTime,
			String topic, boolean isSticky) {
		super();
		this.threadID = threadID;
		this.posted_by = posted_by;
		this.title = title;
		this.contents = contents;
		this.postDate = postDate;
		this.postTime = postTime;
		this.topic = topic;
		this.isSticky = isSticky;
	}

	public Thread() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
