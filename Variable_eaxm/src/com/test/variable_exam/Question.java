package com.test.variable_exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {
	private static String[] question1 = {"육","두","쌍","칸","짜","까","치","곱","창","동","겹","파","자","뽕","면","발"};
	private static String[] question2 = {"건","제","검","박","우","빈","공","부","유","잔","상","든","훤","이","만","호"};
	private static String[] question3 = {"지","원","주","명","우","수","동","환","박","성","연","인","진","정","이","롱"};
	private static String[] question4 = {"코","염","슴","치","호","끼","수","지","고","랑","원","린","가","릴","타","문"};
	private static String[] question5 = {"장","훈","용","찬","서","희","구","진","다","호","최","유","상","열","준","범"};
	private static String[] question6 = {"마","스","콜","두","용","테","고","링","축","역","프","수","양","야","말","승"};
	private static String[] question7 = {"이","플","동","에","두","수","성","나","글","한","케","다","니","레","엘","티"};
	private static String[] question8 = {"환","티","아","봉","마","콜","운","레","사","스","밀","다","수","붕","제","비"};
	private String[] answer;
	private String[] hint;
	private String[][] collect = new String[8][16];
	private int index;
	private List<String> problem;
	private String menu;
	
	public Question(){
		setCollect();
	}
	
	void setInit(){
		setNum();
		setAnswer();
		setHint();
		setProblem();
	}
	
	private void setAnswer(){
		this.answer = new String[] {"곱창", "공유", "이명우", "치타", "유희상", "승마", "케이티", "제티"};
	}
	
	String[] getAnswer(){		
		return this.answer;
	}
	
	private void setHint(){
		this.hint = new String[] {"음식", "남자배우", "우리 반 친구", "동물","우리 반 친구","스포츠","기업","음료수"};
	}
	
	String[] getHint(){		
		return this.hint;
	}
	
	private void setNum(){
		this.index = (int) (Math.random()*8);		
	}
	
	int getNum(){		
		return this.index;
	}
	
	String printProblem(){
		return (getNum() + 1) + "번 문제 : " + getHint();
	}
	
	private void setProblem(){
		this.problem = Arrays.asList(collect[this.index]);
		Collections.shuffle(this.problem);
	}
	
	List<String> getProblem(){
		return this.problem;
	}
	
	private void setMenu(){
		this.menu = "┌──────────────────┐\n│      M E N U     │\n│ 1.게임시작     	   │\n│ 2.게임종료     	   │\n└──────────────────┘";
	}
	
	String getMenu(){
		setMenu();
		return this.menu;
	}
	
	private void setCollect(){
		collect[0] = question1;
		collect[1] = question2;
		collect[2] = question3;
		collect[3] = question4;
		collect[4] = question5;
		collect[5] = question6;
		collect[6] = question7;
		collect[7] = question8;
	}
	
	String[][] getCollect(){
		return this.collect;
	}
}
