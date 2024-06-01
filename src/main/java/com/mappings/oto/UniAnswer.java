package com.mappings.oto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UniAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int answerId;
	private String answer;
	
//	mappedBy = value , value refers to the field/column that is going to be handle
//	the foreign key representation
	
	@OneToOne(mappedBy = "answer")
	private UniQuestion question;
	
	public UniAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UniAnswer( String answer) {
		super();
		this.answer = answer;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "UniAnswer [answerId=" + answerId + ", answer=" + answer + "]";
	}
	
	
}
