package com.mappings.oto;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UniQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	private String question;

	// Remove the below three lines to make the prog. Unidirectional
	@OneToOne
	@Cascade(CascadeType.PERSIST)
	private UniAnswer answer;

	public UniQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UniQuestion(String question, UniAnswer answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public UniAnswer getAnswer() {
		return answer;
	}

	public void setAnswer(UniAnswer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question : " + question + ", \n answer is : =" + answer.getAnswer() + "]";
	}

}
