package com.join.quiz3;

public class QuestionDefault5x5 extends Question implements FiveByFive{
	public QuestionDefault5x5(String keyword, String answer, String questionSource){
		this.keyword = keyword;
		this.answer = answer;
		this.questionSource = questionSource;
		setProblem();
	}
	@Override
	public void setProblem(){
		problem="┌─────────────┐\n│";
		char []chProblem = new char[25];
		char []shProblem = new char[25];
		for(int i=0;i<chProblem.length;i++)
			chProblem[i]=questionSource.charAt(i);
		shProblem = shuffle(chProblem);
		for(int i=0;i<25;i++) {
			if(i==shProblem.length-1)
				problem += " " + shProblem[i] +" │\n└─────────────┘";
			else if((i+1)%5==0 && i!=0)
				problem += " " + shProblem[i] +" │\n│";
			else
				problem += " " + shProblem[i];
		}
	}
	
	@Override
	public char[] shuffle(char[] chProblem){
		char temp;
		int randomInt;
		for(int i=0;i<chProblem.length;i++){
			randomInt=(int)(Math.random()*24);
			temp = chProblem[i];
			chProblem[i] = chProblem[randomInt];
			chProblem[randomInt] = temp;
		}
		return chProblem;
	}
}
