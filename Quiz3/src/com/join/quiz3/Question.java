package com.join.quiz3;

public abstract class Question {
	public String keyword;
	public String answer;
	public String questionSource;
	public String problem;
	
	abstract void setProblem();

	public void setQestionSource(String qestionSource) {
		this.questionSource = qestionSource;
		setProblem();
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getAnswer() {
		return answer;
	}
	
	public String getProblem() {
		return problem;
	}

	public String getQuestion(int state) {
		return (state+"번 문제 : "+keyword);
	}
	
	public boolean isAnswer(String answer){
		if(this.answer.equals(answer))
			return true;
		else
			return false;
	}
	
	abstract char[] shuffle(char[] chProblem);
	
}
