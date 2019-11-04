package com.revature.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

import org.springframework.stereotype.Component;

/**
 * This class is for all threads on the forum
 * It is named ForumThread to avoid conflict with the Java Thread object
 * Will be referred to as a thread
 * @author Robert Li
 *
 */

@Component
@Entity
@Table(name = "Threads")
public class ForumThread {

	
	/**
	 * ID of the thread
	 */
	
	@Id
	@SequenceGenerator(name = "THREADID_SEQ", sequenceName = "thread_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "THREADID_SEQ")
	@Column(name = "THREAD_ID")
	private int threadID;
	
	
	/**
	 * User that posted the thread
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User postedBy;
	
	/**
	 * Title of the thread
	 */
	@Column(name = "title")
	private String title;
	
	
	/**
	 * Contents of the thread
	 */
	@Column(name = "contents")
	private String contents;
	
	/**
	 * Date thread was posted
	 */
	@Column(name = "post_date")
	private LocalDate postDate;
	
	/**
	 * Time thread was posted
	 */
	@Column(name = "post_time")
	private LocalTime postTime;
	
	/**
	 * Topic of the post
	 * Will mainly be used for asking questions
	 */
	@Column(name = "topic")
	private String topic;
	
	/**
	 * Denotes which subforum the thread belongs in
	 */
	@Column(name = "subforum")
	private String subforum;
	
	/**
	 * Date of last post. Is date of thread creation by default
	 */
	@Column(name = "last_post")
	private LocalDateTime lastPost;
	
	/**
	 * Denotes whether thread has been reported
	 */
	@Column(name = "is_reported")
	private boolean isReported;
	
	/**
	 * Denotes whether the thread should be stickied or not
	 */
	@Column(name = "is_sticky")
	private boolean isSticky;

	public int getThreadID() {
		return threadID;
	}

	public void setThreadID(int threadID) {
		this.threadID = threadID;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
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
	
	public String getSubforum() {
		return subforum;
	}

	public void setSubforum(String subforum) {
		this.subforum = subforum;
	}

	public LocalDateTime getLastPost() {
		return lastPost;
	}

	public void setLastPost(LocalDateTime lastPost) {
		this.lastPost = lastPost;
	}

	public boolean getIsReported() {
		return isReported;
	}

	public void setIsReported(boolean isReported) {
		this.isReported = isReported;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + (isReported ? 1231 : 1237);
		result = prime * result + (isSticky ? 1231 : 1237);
		result = prime * result + ((lastPost == null) ? 0 : lastPost.hashCode());
		result = prime * result + ((postDate == null) ? 0 : postDate.hashCode());
		result = prime * result + ((postTime == null) ? 0 : postTime.hashCode());
		result = prime * result + ((postedBy == null) ? 0 : postedBy.hashCode());
		result = prime * result + ((subforum == null) ? 0 : subforum.hashCode());
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
		ForumThread other = (ForumThread) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (isReported != other.isReported)
			return false;
		if (isSticky != other.isSticky)
			return false;
		if (lastPost == null) {
			if (other.lastPost != null)
				return false;
		} else if (!lastPost.equals(other.lastPost))
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
		if (postedBy == null) {
			if (other.postedBy != null)
				return false;
		} else if (!postedBy.equals(other.postedBy))
			return false;
		if (subforum == null) {
			if (other.subforum != null)
				return false;
		} else if (!subforum.equals(other.subforum))
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
		return "ForumThread [threadID=" + threadID + ", posted_by=" + postedBy + ", title=" + title + ", contents="
				+ contents + ", postDate=" + postDate + ", postTime=" + postTime + ", topic=" + topic + ", subforum="
				+ subforum + ", lastPost=" + lastPost + ", isReported=" + isReported + ", isSticky=" + isSticky + "]";
	}

	public ForumThread(int threadID, User postedBy, String title, String contents, LocalDate postDate,
			LocalTime postTime, String topic, String subforum, LocalDateTime lastPost, boolean isReported,
			boolean isSticky) {
		super();
		this.threadID = threadID;
		this.postedBy = postedBy;
		this.title = title;
		this.contents = contents;
		this.postDate = postDate;
		this.postTime = postTime;
		this.topic = topic;
		this.subforum = subforum;
		this.lastPost = lastPost;
		this.isReported = isReported;
		this.isSticky = isSticky;
	}

	public ForumThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	
	
}
