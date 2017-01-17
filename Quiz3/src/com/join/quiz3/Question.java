package com.join.quiz3;

public class Question {
	public String keyword;
	public String answer;
	public String questionSource;
	public String problem;
	
	public void setProblem(){
		problem="";
		char []chProblem = new char[16];
		char []shProblem = new char[16];
		String []strProblem = new String[6];
		
		for(int i=1; i<5; i++)
			strProblem[i]="│";
		for(int i=0;i<chProblem.length;i++)
			chProblem[i]=questionSource.charAt(i);
		shProblem = shuffle(chProblem);
		strProblem[0]=new String("┌───────────┐");
		for (int i = 0; i < 16; i++) {
			strProblem[(i%4)+1] = new String(strProblem[(i%4)+1] + " " + shProblem[i]);
		}
		for(int i=1; i<5; i++)
			strProblem[i]+=" │";
		strProblem[5]=new String("└───────────┘");
		for(int i=0;i<6;i++) {
			problem += strProblem[i]+"\n";
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
