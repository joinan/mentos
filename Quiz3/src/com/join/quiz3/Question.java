package com.join.quiz3;

public class Question {
	public String keyword;
	public String answer;
	public String questionSource;
	public String problem;
	
	public void setProblem(){
		problem="┌───────────┐\n│";
		char []chProblem = new char[16];
		char []shProblem = new char[16];
		for(int i=0;i<chProblem.length;i++)
			chProblem[i]=questionSource.charAt(i);
		shProblem = shuffle(chProblem);
		for(int i=0;i<16;i++) {
			if(i==shProblem.length-1)
				problem += " " + shProblem[i] +" │\n└───────────┘";
			else if((i+1)%4==0 && i!=0)
				problem += " " + shProblem[i] +" │\n│";
			else
				problem += " " + shProblem[i];
		}
	}

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
	
	public char[] shuffle(char[] chProblem){
		char temp;
		int randomInt;
		for(int i=0;i<chProblem.length;i++){
			randomInt=(int)(Math.random()*15);
			temp = chProblem[i];
			chProblem[i] = chProblem[randomInt];
			chProblem[randomInt] = temp;
		}
		return chProblem;
	}
	
}
