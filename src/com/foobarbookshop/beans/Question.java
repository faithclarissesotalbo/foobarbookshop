package com.foobarbookshop.beans;

import java.io.Serializable;

public class Question implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "secquestion";
	public static final String COLUMN_QUESTIONID = "questionID";
	public static final String COLUMN_QUESTION = "question";
	public static final String COLUMN_ACCOUNTID = "accountID";	
	public static final String COLUMN_ANSWER = "answer";

	public String questionid;
	public String accountid;
	public String question;
	public String answer;
	
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
