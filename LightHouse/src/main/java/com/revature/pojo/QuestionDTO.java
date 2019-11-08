package com.revature.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionDTO {

	private int qID;

	private Category cat;

	private String questionName;

	private List<String> answers;

	private String exp;

	private int qRating;

	private String status;

	public QuestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionDTO(int qID, Category cat, String questionName, List<String> answers, String exp, int qRating,
			String status) {
		super();
		this.qID = qID;
		this.cat = cat;
		this.questionName = questionName;
		this.answers = answers;
		this.exp = exp;
		this.qRating = qRating;
		this.status = status;
	}
	
	public QuestionDTO(Question q) {
		this.qID = q.getQuestionID();
		this.cat= q.getCat();
		this.questionName = q.getQuestionName();
		this.answers = new ArrayList<String>();
		this.answers.add(q.getCorrectAnswer());
		this.answers.add(q.getWrongAnswer1());
		this.answers.add(q.getWrongAnswer2());
		this.answers.add(q.getWrongAnswer3());
		Collections.shuffle(this.answers);
		this.exp = q.getExplanation();
		this.qRating = q.getQuestionRating();
		this.status = q.getStatus();
	}

	public int getqID() {
		return qID;
	}

	public void setqID(int qID) {
		this.qID = qID;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public int getqRating() {
		return qRating;
	}

	public void setqRating(int qRating) {
		this.qRating = qRating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + ((cat == null) ? 0 : cat.hashCode());
		result = prime * result + ((exp == null) ? 0 : exp.hashCode());
		result = prime * result + qID;
		result = prime * result + qRating;
		result = prime * result + ((questionName == null) ? 0 : questionName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		QuestionDTO other = (QuestionDTO) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (cat == null) {
			if (other.cat != null)
				return false;
		} else if (!cat.equals(other.cat))
			return false;
		if (exp == null) {
			if (other.exp != null)
				return false;
		} else if (!exp.equals(other.exp))
			return false;
		if (qID != other.qID)
			return false;
		if (qRating != other.qRating)
			return false;
		if (questionName == null) {
			if (other.questionName != null)
				return false;
		} else if (!questionName.equals(other.questionName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionDTO [qID=" + qID + ", cat=" + cat + ", questionName=" + questionName + ", answers=" + answers
				+ ", exp=" + exp + ", qRating=" + qRating + ", status=" + status + "]";
	}

	
}
