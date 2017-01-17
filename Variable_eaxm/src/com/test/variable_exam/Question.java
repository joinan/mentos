package com.test.variable_exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {
	String[] quest = new String[4];
	String[] ans;
	int index;
	List<String> list;
//	public Question(){
//		quest = null; list = null; ans = null;
//	}
	
	List<String> shuffle(String[] question){
		list = Arrays.asList(question);
		Collections.shuffle(list);
		return list;
	}
	
	int pick(){
		index = (int) (Math.random()*4);
		return index;
	}
	
	
	
}
