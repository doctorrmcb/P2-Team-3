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


/**
 * Class for all posts
 * @author Robert Li
 *
 */

@Entity
@Table(name = "Posts")
public class Post {
	
	/**
	 * ID of the post
	 */
	@Id
	@SequenceGenerator(name = "POSTID_SEQ", sequenceName = "post_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTID_SEQ")
	@Column(name = "post_id")
	private int postID;
	
	/**
	 * The thread the post replied to
	 */
	@ManyToOne
	@JoinColumn(name = "thread_id")
	private Thread threadID;
	
	/**
	 * The user who posted the Post
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User posted_by;
	
	/**
	 * Contents of the post
	 */
	@Column(name = "contents")
	private String contents;
	
	/**
	 * Date the post was posted
	 */
	@Column(name = "post_date")
	private LocalDate postDate;
	
	/**
	 * Time the post was posted
	 */
	@Column(name = "post_time")
	private LocalTime postTime;

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public Thread getThreadID() {
		return threadID;
	}

	public void setThreadID(Thread threadID) {
		this.threadID = threadID;
	}

	public User getPosted_by() {
		return posted_by;
	}

	public void setPosted_by(User posted_by) {
		this.posted_by = posted_by;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((postDate == null) ? 0 : postDate.hashCode());
		result = prime * result + postID;
		result = prime * result + ((postTime == null) ? 0 : postTime.hashCode());
		result = prime * result + ((posted_by == null) ? 0 : posted_by.hashCode());
		result = prime * result + ((threadID == null) ? 0 : threadID.hashCode());
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
		Post other = (Post) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (postDate == null) {
			if (other.postDate != null)
				return false;
		} else if (!postDate.equals(other.postDate))
			return false;
		if (postID != other.postID)
			return false;
		if (postTime == null) {
			if (other.postTime != null)
				return false;
		} else if (!postTime.equals(other.postTime))
			return false;
		if (posted_by == null) {
			if (other.posted_by != null)
				return false;
		} else if (!posted_by.equals(other.posted_by))
			return false;
		if (threadID == null) {
			if (other.threadID != null)
				return false;
		} else if (!threadID.equals(other.threadID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [postID=" + postID + ", threadID=" + threadID + ", posted_by=" + posted_by + ", contents="
				+ contents + ", postDate=" + postDate + ", postTime=" + postTime + "]";
	}

	public Post(int postID, Thread threadID, User posted_by, String contents, LocalDate postDate, LocalTime postTime) {
		super();
		this.postID = postID;
		this.threadID = threadID;
		this.posted_by = posted_by;
		this.contents = contents;
		this.postDate = postDate;
		this.postTime = postTime;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
