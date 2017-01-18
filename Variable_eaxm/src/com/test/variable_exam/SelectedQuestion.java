package com.test.variable_exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectedQuestion extends Question{
	List<String> problem;
	String[][] collect;
	String[] answerlist;
	String[] hintlist;
	String hint;
	String answer;
	String menu;
	String describe;
	static final int index;
	
	static {
		index = 7;
	}
	public SelectedQuestion(){
		super();
		super.setInit();
		this.collect = super.getCollect();
		this.menu = super.getMenu();
		this.hint = getHint()[getNum()];
		this.describe = (getNum() + 1) + "번째 문제 : " + this.hint;
		this.answer = getAnswer()[getNum()];
		this.problem = getProblem();
		Collections.shuffle(this.problem);
	}
	
	@Override
	List<String> getProblem(){		
		return Arrays.asList(this.collect[getNum()]);
	}
	
	@Override
	int getNum(){
		return index - super.getNum();
	}
	
	@Override
	String[] getHint(){
		this.hintlist = super.getHint();
		return this.hintlist;
	}
	
	@Override
	String[] getAnswer(){
		this.answerlist = super.getAnswer();
		return this.answerlist;
	}
	
	
}
